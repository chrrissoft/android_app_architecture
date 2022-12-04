package com.chrrissoft.marvel.framework.comics

import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.Comic
import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.comics.ComicsDataSource.LocalComicsDataSource
import com.chrrissoft.marvel.data.comics.ComicsDataSource.RemoteComicsDataSource
import com.chrrissoft.marvel.data.comics.ComicsRepo
import com.chrrissoft.marvel.data.comics.ComicsRepo.RequestOf.*
import com.chrrissoft.marvel.data.comics.ComicsRepo.Source.LOCAL
import com.chrrissoft.marvel.data.comics.ComicsRepo.Source.REMOTE
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.comics.res.ComicResState.*
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState.Error as CharsError
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState.Loading as CharsLoading
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState.Success as CharsSuccess
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState.Error as ComicsError
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState.Loading as ComicsLoading
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState.Success as ComicsSuccess
import com.chrrissoft.marvel.data.events.res.EventsPrevResState.Error as EventsError
import com.chrrissoft.marvel.data.events.res.EventsPrevResState.Loading as EventsLoading
import com.chrrissoft.marvel.data.events.res.EventsPrevResState.Success as EventsSuccess
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState.Error as SeriesError
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState.Loading as SeriesLoading
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState.Success as SeriesSuccess
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState.Error as StoriesError
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState.Loading as StoriesLoading
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState.Success as StoriesSuccess
import com.chrrissoft.marvel.framework.chars.datasource.CharsOffset
import com.chrrissoft.marvel.framework.comics.datasource.ComicsOffset
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.series.datasource.SeriesOffset
import com.chrrissoft.marvel.framework.stories.datasource.StoriesOffset
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject


class ComicsRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteComicsDataSource,
    private val localDataSource: LocalComicsDataSource,
) : ComicsRepo() {

    private var cachedId: Int? = null
    private var cachedInfo = Comic()

    private val cachedChars = mutableListOf<CharsPreview>()
    private val cachedComics = mutableListOf<ComicPreview>()
    private val cachedSeries = mutableListOf<SeriesPreview>()
    private val cachedStories = mutableListOf<StoriesPreview>()
    private val cachedEvents = mutableListOf<EventPreview>()

    private var charsOffset = CharsOffset()
    private var comicsOffset = ComicsOffset()
    private var seriesOffset = SeriesOffset()
    private var storiesOffset = StoriesOffset()
    private var eventsOffset = EventsOffset()


    override fun getPreviews(source: Source): Flow<ComicsPrevRes> {
        return when (source) {
            LOCAL -> tryLocalPreviews()
            REMOTE -> tryRemotePreviews()
        }
    }

    override fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Comic> {

        if (cachedId == null) cachedId = id
        else resetCaches(id)

        return channelFlow {

            channel.send(cachedInfo)
            when (requestOf) {
                COMIC -> launch(IO) {
                    getSelf(id, source).collect {
                        cachedInfo = cachedInfo.copy(self = it)
                        channel.send(cachedInfo)
                    }
                }

                CHARS -> launch(IO) {
                    getChars(id, source).collect {
                        cachedInfo = cachedInfo.copy(characters = it)
                        channel.send(cachedInfo)
                    }
                }

                SERIES -> launch(IO) {
                    getSeries(id, source).collect {
                        cachedInfo = cachedInfo.copy(series = it)
                        channel.send(cachedInfo)
                    }
                }

                STORIES -> launch(IO) {
                    getStories(id, source).collect {
                        cachedInfo = cachedInfo.copy(stories = it)
                        channel.send(cachedInfo)
                    }
                }

                EVENTS -> launch(IO) {
                    getEvents(id, source).collect {
                        cachedInfo = cachedInfo.copy(events = it)
                        channel.send(cachedInfo)
                    }
                }
            }

        }
    }


    /* *************************  Attempts  ************************* */

    override fun getSelf(id: Int, source: Source): Flow<ComicRes> {
        return flow {
            emit(ComicRes(Loading()))
            val char = cachedComics.first { it.id == id }
            emit(ComicRes(Success(char.id, char.title, char.image)))
        }.catch {
            when (source) {
                REMOTE -> tryRemoteGetSelf(id).collect { emit(it) }
                LOCAL -> tryLocalGetSelf(id).collect { emit(it) }
            }
        }
    }

    override fun getChars(id: Int, source: Source): Flow<CharsPrevRes> {
        return when (source) {
            LOCAL -> tryRemoteChars(id)
            REMOTE -> tryLocaleChars(id)
        }
    }

    override fun getSeries(id: Int, source: Source): Flow<SeriesPrevRes> {
        return when (source) {
            LOCAL -> tryLocalSeries(id)
            REMOTE -> tryRemoteSeries(id)
        }
    }

    override fun getStories(id: Int, source: Source): Flow<StoriesPrevRes> {
        return when (source) {
            LOCAL -> tryLocalStories(id)
            REMOTE -> tryRemoteStories(id)
        }
    }

    override fun getEvents(id: Int, source: Source): Flow<EventsPrevRes> {
        return when (source) {
            LOCAL -> tryLocaleEvents(id)
            REMOTE -> tryRemoteEvents(id)
        }
    }


    /* *************************  Internal Remote Attempts  ************************* */

    private fun tryLocalGetSelf(id: Int): Flow<ComicRes> {
        return flow {
            emit(ComicRes(Loading()))
            localDataSource.getComic(id).collect {
                emit(ComicRes(Success(it.id, it.title, it.image)))
            }
        }.catch { ComicRes(Error(it)) }
    }

    private fun tryRemotePreviews(): Flow<ComicsPrevRes> {
        return flow {
            emit(ComicsPrevRes(ComicsLoading(cachedComics)))
            remoteDataSource.getComics(comicsOffset).collect { updateComicsCaches(it) }
            emit(ComicsPrevRes(ComicsSuccess(cachedComics)))
        }.catch { emit(ComicsPrevRes(ComicsError(cachedComics, it))) }
    }

    private fun tryRemoteChars(id: Int): Flow<CharsPrevRes> {
        return flow {
            emit(CharsPrevRes(CharsLoading(cachedChars)))
            remoteDataSource.getChars(id, charsOffset).collect { updateCharsCaches(it) }
            emit(CharsPrevRes(CharsSuccess(cachedChars)))
        }.catch { emit(CharsPrevRes(CharsError(cachedChars, it))) }
    }

    private fun tryRemoteSeries(id: Int): Flow<SeriesPrevRes> {
        return flow {
            emit(SeriesPrevRes(SeriesLoading(cachedSeries)))
            remoteDataSource.getSeries(id, seriesOffset).collect { updateSeriesCaches(it) }
            emit(SeriesPrevRes(SeriesSuccess(cachedSeries)))
        }.catch { emit(SeriesPrevRes(SeriesError(cachedSeries, it))) }
    }

    private fun tryRemoteStories(id: Int): Flow<StoriesPrevRes> {
        return flow {
            emit(StoriesPrevRes(StoriesLoading(cachedStories)))
            remoteDataSource.getStories(id, storiesOffset).collect { updateStoriesCaches(it) }
            emit(StoriesPrevRes(StoriesSuccess(cachedStories)))
        }.catch { emit(StoriesPrevRes(StoriesError(cachedStories, it))) }
    }

    private fun tryRemoteEvents(id: Int): Flow<EventsPrevRes> {
        return flow {
            emit(EventsPrevRes(EventsLoading(cachedEvents)))
            remoteDataSource.getEvents(id, eventsOffset).collect { updateEventsCaches(it) }
            emit(EventsPrevRes(EventsSuccess(cachedEvents)))
        }.catch { emit(EventsPrevRes(EventsError(cachedEvents, it))) }
    }


    /* *************************  Internal Locale Attempts  ************************* */

    private fun tryRemoteGetSelf(id: Int): Flow<ComicRes> {
        return flow {
            emit(ComicRes(Loading()))
            remoteDataSource.getComic(id)
                .collect { emit(ComicRes(Success(it.id, it.title, it.image))) }
        }.catch { emit(ComicRes(Error(it))) }
    }

    private fun tryLocalPreviews(): Flow<ComicsPrevRes> {
        return flow {
            emit(ComicsPrevRes(ComicsLoading(cachedComics)))
            localDataSource.getComics(comicsOffset).collect { updateComicsCaches(it, it.size) }
            emit(ComicsPrevRes(ComicsSuccess(cachedComics)))
        }.catch { ComicsPrevRes(ComicsError(cachedComics, it)) }
    }

    private fun tryLocaleChars(id: Int): Flow<CharsPrevRes> {
        return flow {
            emit(CharsPrevRes(CharsLoading(cachedChars)))
            localDataSource.getChars(id, charsOffset).collect { updateCharsCaches(it, it.size) }
            emit(CharsPrevRes(CharsSuccess(cachedChars)))
        }.catch { CharsPrevRes(CharsError(cachedChars, it)) }
    }

    private fun tryLocalSeries(id: Int): Flow<SeriesPrevRes> {
        return flow {
            emit(SeriesPrevRes(SeriesLoading(cachedSeries)))
            localDataSource.getSeries(id, seriesOffset).collect { updateSeriesCaches(it, it.size) }
            emit(SeriesPrevRes(SeriesSuccess(cachedSeries)))
        }.catch { SeriesPrevRes(SeriesError(cachedSeries, it)) }
    }

    private fun tryLocalStories(id: Int): Flow<StoriesPrevRes> {
        return flow {
            emit(StoriesPrevRes(StoriesLoading(cachedStories)))
            localDataSource.getStories(id, storiesOffset).collect { updateStoriesCaches(it, it.size) }
            emit(StoriesPrevRes(StoriesSuccess(cachedStories)))
        }.catch { StoriesPrevRes(StoriesError(cachedStories, it)) }
    }

    private fun tryLocaleEvents(id: Int): Flow<EventsPrevRes> {
        return flow {
            emit(EventsPrevRes(EventsLoading(cachedEvents)))
            localDataSource.getEvents(id, eventsOffset).collect { updateEventsCaches(it, it.size) }
            emit(EventsPrevRes(EventsSuccess(cachedEvents)))
        }.catch { EventsPrevRes(EventsError(cachedEvents, it)) }
    }


    /* *************************  Internal controllers  ************************* */

    // this is called when user selects a new info char
    private fun resetCaches(id: Int) {
        if (cachedId != id) {
            cachedChars.clear()
            cachedSeries.clear()
            cachedStories.clear()
            cachedEvents.clear()

            charsOffset = charsOffset.clean()
            seriesOffset = seriesOffset.clean()
            storiesOffset = storiesOffset.clean()
            eventsOffset = eventsOffset.clean()

            cachedInfo = cachedInfo.clean()

            cachedId = id
        }
    }


    // this methods are called when user request for more data

    private fun updateCharsCaches(result: List<CharsPreview>, offset: Int = charsOffset.value) {
        cachedChars.addAll(result)
        charsOffset = charsOffset.update(offset)
    }

    private fun updateComicsCaches(result: List<ComicPreview>, offset: Int = comicsOffset.value) {
        cachedComics.addAll(result)
        charsOffset = charsOffset.update(offset)
    }

    private fun updateSeriesCaches(result: List<SeriesPreview>, offset: Int = seriesOffset.value) {
        cachedSeries.addAll(result)
        charsOffset = charsOffset.update(offset)
    }

    private fun updateStoriesCaches(result: List<StoriesPreview>, offset: Int = storiesOffset.value) {
        cachedStories.addAll(result)
        charsOffset = charsOffset.update(offset)
    }

    private fun updateEventsCaches(result: List<EventPreview>, offset: Int = eventsOffset.value) {
        cachedEvents.addAll(result)
        charsOffset = charsOffset.update(offset)
    }

}

package com.chrrissoft.marvel.framework.chars

import com.chrrissoft.marvel.data.chars.Char
import com.chrrissoft.marvel.data.chars.CharsDataSource.LocalCharsDataSource
import com.chrrissoft.marvel.data.chars.CharsDataSource.RemoteCharsDataSource
import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.chars.CharsRepo
import com.chrrissoft.marvel.data.chars.CharsRepo.RequestOf.*
import com.chrrissoft.marvel.data.chars.CharsRepo.Source.*
import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.chars.res.CharResState.*
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
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


class CharsRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteCharsDataSource,
    private val localDataSource: LocalCharsDataSource,
) : CharsRepo() {

    private var cachedId: Int? = null
    private var cachedInfo = Char()

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


    override fun getPreviews(source: Source): Flow<CharsPrevRes> {
        return when (source) {
            LOCAL -> tryLocalChars()
            REMOTE -> tryRemoteChars()
        }
    }

    override fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Char> {

        if (cachedId == null) cachedId = id
        else resetCaches(id)

        return channelFlow {

            channel.send(cachedInfo)

            when (requestOf) {
                CHAR -> launch(IO) {
                    getSelf(id, source).collect {
                        cachedInfo = cachedInfo.copy(self = it)
                        channel.send(cachedInfo)
                    }
                }

                COMICS -> launch(IO) {
                    getComics(id, source).collect {
                        cachedInfo = cachedInfo.copy(comics = it)
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

    override fun getSelf(id: Int, source: Source): Flow<CharRes> {
        return flow {
            emit(CharRes(Loading()))
            val char = cachedChars.first { it.id == 1009175 }
            emit(CharRes(Success(char.id, char.name, char.image)))
        }.catch {
            when (source) {
                REMOTE -> tryRemoteGetSelf(id).collect { emit(it) }
                LOCAL -> tryLocalGetSelf(id).collect { emit(it) }
            }
        }
    }

    override fun getComics(id: Int, source: Source): Flow<ComicsPrevRes> {
        return when (source) {
            LOCAL -> tryLocaleComics(id)
            REMOTE -> tryRemoteComics(id)
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

    private fun tryRemoteGetSelf(id: Int): Flow<CharRes> {
        return flow {
            emit(CharRes(Loading()))
            remoteDataSource.getChar(id).collect {
                emit(CharRes(Success(it.id, it.name, it.image)))
            }
        }.catch { emit(CharRes(Error(it))) }
    }

    private fun tryRemoteChars(): Flow<CharsPrevRes> {
        return flow {
            emit(CharsPrevRes(CharsLoading(cachedChars)))
            remoteDataSource.getChars(charsOffset).collect { updateCharsCaches(it, it.size) }
            emit(CharsPrevRes(CharsSuccess(cachedChars)))
        }.catch { emit(CharsPrevRes(CharsError(cachedChars, it))) }
    }

    private fun tryRemoteComics(id: Int): Flow<ComicsPrevRes> {
        return flow {
            emit(ComicsPrevRes(ComicsLoading(cachedComics)))
            remoteDataSource.getComics(id, comicsOffset).collect { updateComicsCaches(it, it.size) }
            emit(ComicsPrevRes(ComicsSuccess(cachedComics)))
        }.catch { emit(ComicsPrevRes(ComicsError(cachedComics, it))) }
    }

    private fun tryRemoteSeries(id: Int): Flow<SeriesPrevRes> {
        return flow {
            emit(SeriesPrevRes(SeriesLoading(cachedSeries)))
            remoteDataSource.getSeries(id, seriesOffset).collect { updateSeriesCaches(it, it.size) }
            emit(SeriesPrevRes(SeriesSuccess(cachedSeries)))
        }.catch { emit(SeriesPrevRes(SeriesError(cachedSeries, it))) }
    }

    private fun tryRemoteStories(id: Int): Flow<StoriesPrevRes> {
        return flow {
            emit(StoriesPrevRes(StoriesLoading(cachedStories)))
            remoteDataSource.getStories(id, storiesOffset).collect { updateStoriesCaches(it, it.size) }
            emit(StoriesPrevRes(StoriesSuccess(cachedStories)))
        }.catch { emit(StoriesPrevRes(StoriesError(cachedStories, it))) }
    }

    private fun tryRemoteEvents(id: Int): Flow<EventsPrevRes> {
        return flow {
            emit(EventsPrevRes(EventsLoading(cachedEvents)))
            remoteDataSource.getEvents(id, eventsOffset).collect { updateEventsCaches(it, it.size) }
            emit(EventsPrevRes(EventsSuccess(cachedEvents)))
        }.catch { emit(EventsPrevRes(EventsError(cachedEvents, it))) }
    }


    /* *************************  Internal Locale Attempts  ************************* */

    private fun tryLocalGetSelf(id: Int): Flow<CharRes> {
        return flow {
            emit(CharRes(Loading()))
            localDataSource.getChar(id).collect { emit(CharRes(Success(it.id, it.name, it.image))) }
        }.catch { CharRes(Error(it)) }
    }

    private fun tryLocalChars(): Flow<CharsPrevRes> {
        return flow {
            emit(CharsPrevRes(CharsLoading(cachedChars)))
            localDataSource.getChars(charsOffset).collect { updateCharsCaches(it, it.size) }
            emit(CharsPrevRes(CharsSuccess(cachedChars)))
        }.catch { CharsPrevRes(CharsError(cachedChars, it)) }
    }

    private fun tryLocaleComics(id: Int): Flow<ComicsPrevRes> {
        return flow {
            emit(ComicsPrevRes(ComicsLoading(cachedComics)))
            localDataSource.getComics(id, comicsOffset).collect { updateComicsCaches(it, it.size) }
            emit(ComicsPrevRes(ComicsSuccess(cachedComics)))
        }.catch { ComicsPrevRes(ComicsError(cachedComics, it)) }
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
            localDataSource.getStories(id, storiesOffset)
                .collect { updateStoriesCaches(it, it.size) }
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
            cachedComics.clear()
            cachedSeries.clear()
            cachedStories.clear()
            cachedEvents.clear()

            comicsOffset = comicsOffset.clean()
            seriesOffset = seriesOffset.clean()
            storiesOffset = storiesOffset.clean()
            eventsOffset = eventsOffset.clean()

            cachedInfo = cachedInfo.clean()

            cachedId = id
        }
    }


    // this methods are called when user request for more data

    private fun updateCharsCaches(result: List<CharsPreview>, offset: Int) {
        cachedChars.addAll(result)
        charsOffset = charsOffset.update(offset)
    }

    private fun updateComicsCaches(result: List<ComicPreview>, offset: Int) {
        cachedComics.addAll(result)
        charsOffset = charsOffset.update(offset)
    }

    private fun updateSeriesCaches(result: List<SeriesPreview>, offset: Int) {
        cachedSeries.addAll(result)
        charsOffset = charsOffset.update(offset)
    }

    private fun updateStoriesCaches(result: List<StoriesPreview>, offset: Int) {
        cachedStories.addAll(result)
        charsOffset = charsOffset.update(offset)
    }

    private fun updateEventsCaches(result: List<EventPreview>, offset: Int) {
        cachedEvents.addAll(result)
        charsOffset = charsOffset.update(offset)
    }

}

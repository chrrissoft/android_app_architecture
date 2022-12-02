package com.chrrissoft.marvel.framework.events

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.chrrissoft.marvel.data.events.EventsRepo
import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.framework.chars.datasource.*
import com.chrrissoft.marvel.framework.comics.datasource.ComicsOffset
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.series.datasource.SeriesOffset
import com.chrrissoft.marvel.framework.stories.datasource.StoriesOffset
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
import com.chrrissoft.marvel.data.events.EventsDataSource.LocalEventsDataSource
import com.chrrissoft.marvel.data.events.EventsDataSource.RemoteEventsDataSource
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.events.res.EventResState.Error
import com.chrrissoft.marvel.data.events.res.EventResState.Loading
import com.chrrissoft.marvel.data.events.res.EventResState.Success


class EventsRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteEventsDataSource,
    private val localDataSource: LocalEventsDataSource,
) : EventsRepo() {

    private var cachedId: Int? = null
    private val cachedInfo = Event()

    private var selfIsFind = false
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


    override fun getPreviews(source: Source): Flow<EventsPrevRes> {
        return when (source) {
            Source.LOCAL -> tryLocalePreviews()
            Source.REMOTE -> tryRemotePreviews()
        }
    }

    override fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Event> {

        if (cachedId == null) cachedId = id
        else resetCaches(id)

        return flow {

            emit(cachedInfo)

            if (!selfIsFind) {
                withContext(IO) {
                    getSelfFromCache(id).collect { emit(cachedInfo.copy(self = it)) }
                    selfIsFind = true
                }
            }

            when (requestOf) {

                RequestOf.CHARS -> withContext(IO) {
                    getChars(id, source).collect { emit(cachedInfo.copy(chars = it)) }
                }

                RequestOf.COMICS -> withContext(IO) {
                    getComics(id, source).collect { emit(cachedInfo.copy(comics = it)) }
                }

                RequestOf.SERIES -> withContext(IO) {
                    getSeries(id, source).collect { emit(cachedInfo.copy(series = it)) }
                }

                RequestOf.STORIES -> withContext(IO) {
                    getStories(id, source).collect { emit(cachedInfo.copy(stories = it)) }
                }
            }

        }
    }


/* *************************  Internal Attempts  ************************* */

    override fun getSelfFromCache(id: Int): Flow<EventRes> {
        return flow {
            emit(EventRes(Loading()))
            val char = cachedChars.first { it.id == id }
            emit(EventRes(Success(char.id, char.name, char.image)))
        }.catch { emit(EventRes(Error(it))) }
    }

    override fun getChars(id: Int, source: Source): Flow<CharsPrevRes> {
        return when (source) {
            Source.LOCAL -> tryLocalChars(id)
            Source.REMOTE -> tryRemoteChars(id)
        }
    }

    override fun getComics(id: Int, source: Source): Flow<ComicsPrevRes> {
        return when (source) {
            Source.LOCAL -> tryLocaleComics(id)
            Source.REMOTE -> tryRemoteComics(id)
        }
    }

    override fun getSeries(id: Int, source: Source): Flow<SeriesPrevRes> {
        return when (source) {
            Source.LOCAL -> tryLocalSeries(id)
            Source.REMOTE -> tryRemoteSeries(id)
        }
    }

    override fun getStories(id: Int, source: Source): Flow<StoriesPrevRes> {
        return when (source) {
            Source.LOCAL -> tryLocalStories(id)
            Source.REMOTE -> tryRemoteStories(id)
        }
    }


/* *************************  Internal Remote Attempts  ************************* */

    private fun tryRemoteChars(id: Int): Flow<CharsPrevRes> {
        return flow {
            emit(CharsPrevRes(CharsLoading(cachedChars)))
            remoteDataSource.getChars(id, charsOffset).collect { updateCharsCaches(it) }
            emit(CharsPrevRes(CharsSuccess(cachedChars)))
        }.catch { emit(CharsPrevRes(CharsError(cachedChars, it))) }
    }

    private fun tryRemoteComics(id: Int): Flow<ComicsPrevRes> {
        return flow {
            emit(ComicsPrevRes(ComicsLoading(cachedComics)))
            remoteDataSource.getComics(id, comicsOffset).collect { updateComicsCaches(it) }
            emit(ComicsPrevRes(ComicsSuccess(cachedComics)))
        }.catch { emit(ComicsPrevRes(ComicsError(cachedComics, it))) }
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

    private fun tryRemotePreviews(): Flow<EventsPrevRes> {
        return flow {
            emit(EventsPrevRes(EventsLoading(cachedEvents)))
            remoteDataSource.getEvents(eventsOffset).collect { updateEventsCaches(it) }
            emit(EventsPrevRes(EventsSuccess(cachedEvents)))
        }.catch { emit(EventsPrevRes(EventsError(cachedEvents, it))) }
    }


/* *************************  Internal Locale Attempts  ************************* */

    private fun tryLocalChars(id: Int): Flow<CharsPrevRes> {
        return flow {
            emit(CharsPrevRes(CharsLoading(cachedChars)))
            localDataSource.getChars(id, charsOffset).collect { updateCharsCaches(it) }
            emit(CharsPrevRes(CharsSuccess(cachedChars)))
        }.catch { CharsPrevRes(CharsError(cachedChars, it)) }
    }

    private fun tryLocaleComics(id: Int): Flow<ComicsPrevRes> {
        return flow {
            emit(ComicsPrevRes(ComicsLoading(cachedComics)))
            localDataSource.getComics(id, comicsOffset).collect { updateComicsCaches(it) }
            emit(ComicsPrevRes(ComicsSuccess(cachedComics)))
        }.catch { ComicsPrevRes(ComicsError(cachedComics, it)) }
    }

    private fun tryLocalSeries(id: Int): Flow<SeriesPrevRes> {
        return flow {
            emit(SeriesPrevRes(SeriesLoading(cachedSeries)))
            localDataSource.getSeries(id, seriesOffset).collect { updateSeriesCaches(it) }
            emit(SeriesPrevRes(SeriesSuccess(cachedSeries)))
        }.catch { SeriesPrevRes(SeriesError(cachedSeries, it)) }
    }

    private fun tryLocalStories(id: Int): Flow<StoriesPrevRes> {
        return flow {
            emit(StoriesPrevRes(StoriesLoading(cachedStories)))
            localDataSource.getStories(id, storiesOffset).collect { updateStoriesCaches(it) }
            emit(StoriesPrevRes(StoriesSuccess(cachedStories)))
        }.catch { StoriesPrevRes(StoriesError(cachedStories, it)) }
    }

    private fun tryLocalePreviews(): Flow<EventsPrevRes> {
        return flow {
            emit(EventsPrevRes(EventsLoading(cachedEvents)))
            localDataSource.getEvents(eventsOffset).collect { updateEventsCaches(it) }
            emit(EventsPrevRes(EventsSuccess(cachedEvents)))
        }.catch { EventsPrevRes(EventsError(cachedEvents, it)) }
    }


/* *************************  Internal controllers  ************************* */

    // this is called when user selects a new info char
    private fun resetCaches(id: Int) {
        if (cachedId != id) {
            cachedChars.clear()
            cachedComics.clear()
            cachedSeries.clear()
            cachedStories.clear()
            cachedEvents.clear()

            charsOffset = charsOffset.clean()
            comicsOffset = comicsOffset.clean()
            seriesOffset = seriesOffset.clean()
            storiesOffset = storiesOffset.clean()
            eventsOffset = eventsOffset.clean()

            cachedId = id
            selfIsFind = false
        }
    }


    // this methods are called when user request for more data

    private fun updateCharsCaches(result: List<CharsPreview>) {
        cachedChars.addAll(result)
        charsOffset = charsOffset.update(charsOffset.value)
    }

    private fun updateComicsCaches(result: List<ComicPreview>) {
        cachedComics.addAll(result)
        charsOffset = charsOffset.update(charsOffset.value)
    }

    private fun updateSeriesCaches(result: List<SeriesPreview>) {
        cachedSeries.addAll(result)
        charsOffset = charsOffset.update(charsOffset.value)
    }

    private fun updateStoriesCaches(result: List<StoriesPreview>) {
        cachedStories.addAll(result)
        charsOffset = charsOffset.update(charsOffset.value)
    }

    private fun updateEventsCaches(result: List<EventPreview>) {
        cachedEvents.addAll(result)
        charsOffset = charsOffset.update(charsOffset.value)
    }

}

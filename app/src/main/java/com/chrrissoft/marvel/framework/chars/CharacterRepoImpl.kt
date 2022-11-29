package com.chrrissoft.marvel.framework.chars

import javax.inject.Inject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers.IO
import com.chrrissoft.marvel.data.chars.Character
import com.chrrissoft.marvel.data.chars.CharacterDataSource.LocalCharacterDataSource
import com.chrrissoft.marvel.data.chars.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.data.chars.CharsRepo
import com.chrrissoft.marvel.data.chars.CharsRepo.Source
import com.chrrissoft.marvel.data.chars.CharsRepo.Source.LOCAL
import com.chrrissoft.marvel.data.chars.CharsRepo.Source.REMOTE
import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.chars.res.CharResState.*
import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.framework.chars.datasource.*
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

class CharacterRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteCharacterDataSource,
    private val localDataSource: LocalCharacterDataSource,
) : CharsRepo {

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

    companion object {
        private const val TAG = "CharacterRepoImpl"
    }

    override fun getChars(source: Source): Flow<CharsPrevRes> {
        return when (source) {
            LOCAL -> tryLocalChars()
            REMOTE -> tryRemoteChars()
        }
    }

    override fun getChar(id: Int, source: Source): Flow<Character> {
        return flow {
            emit(Character())

            withContext(IO) { tryFindChar(id).collect { emit(Character(self = it)) } }

            withContext(IO) { getComics(id, source).collect { emit(Character(comics = it)) } }

            withContext(IO) { getSeries(id, source).collect { emit(Character(series = it)) } }

            withContext(IO) { getStories(id, source).collect { emit(Character(stories = it)) } }

            withContext(IO) { getEvents(id, source).collect { emit(Character(events = it)) } }
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

    private fun tryFindChar(id: Int) : Flow<CharRes> {
        return flow {
            emit(CharRes(Loading()))
            val char = cachedChars.first { it.id == id }
            emit(CharRes(Success(char.id, char.name, char.image)))
        }.catch {
            emit(CharRes(Error(NullPointerException())))
        }
    }

    private fun tryRemoteChars(): Flow<CharsPrevRes> {
        return flow {
            emit(CharsPrevRes(CharsLoading(cachedChars)))
            remoteDataSource.getChars(charsOffset).collect {
                cachedChars.addAll(it)
                charsOffset = charsOffset.copy(charsOffset.value + 20)
            }
            emit(CharsPrevRes(CharsSuccess(cachedChars)))
        }.catch { tryLocalChars().collect { emit(it) } }
    }

    private fun tryRemoteComics(id: Int): Flow<ComicsPrevRes> {
        return flow {
            emit(ComicsPrevRes(ComicsLoading(cachedComics)))
            remoteDataSource.getComics(id, comicsOffset).collect {
                cachedComics.addAll(it)
                charsOffset = charsOffset.copy(charsOffset.value + 20)
            }
            emit(ComicsPrevRes(ComicsSuccess(cachedComics)))
        }
    }

    private fun tryRemoteSeries(id: Int): Flow<SeriesPrevRes> {
        return flow {
            emit(SeriesPrevRes(SeriesLoading(cachedSeries)))
            remoteDataSource.getSeries(id, seriesOffset).collect {
                cachedSeries.addAll(it)
                charsOffset = charsOffset.copy(charsOffset.value + 20)
            }
            emit(SeriesPrevRes(SeriesSuccess(cachedSeries)))
        }
    }

    private fun tryRemoteStories(id: Int): Flow<StoriesPrevRes> {
        return flow {
            emit(StoriesPrevRes(StoriesLoading(cachedStories)))
            remoteDataSource.getStories(id, storiesOffset).collect {
                cachedStories.addAll(it)
                charsOffset = charsOffset.copy(charsOffset.value + 20)
            }
            emit(StoriesPrevRes(StoriesSuccess(cachedStories)))
        }
    }

    private fun tryRemoteEvents(id: Int): Flow<EventsPrevRes> {
        return flow {
            emit(EventsPrevRes(EventsLoading(cachedEvents)))
            remoteDataSource.getEvents(id, eventsOffset).collect {
                cachedEvents.addAll(it)
                charsOffset = charsOffset.copy(charsOffset.value + 20)
            }
            emit(EventsPrevRes(EventsSuccess(cachedEvents)))
        }
    }


    /* *************************  Internal Locale Attempts  ************************* */

    private fun tryLocalChars(): Flow<CharsPrevRes> {
        return flow {
            emit(CharsPrevRes(CharsLoading(cachedChars)))
            localDataSource.getChars(charsOffset).collect { cachedChars.addAll(it) }
            emit(CharsPrevRes(CharsSuccess(cachedChars)))
        }.catch { CharsPrevRes(CharsError(cachedChars)) }
    }

    private fun tryLocaleComics(id: Int): Flow<ComicsPrevRes> {
        return flow {
            emit(ComicsPrevRes(ComicsLoading(cachedComics)))
            localDataSource.getComics(id, comicsOffset).collect { cachedComics.addAll(it) }
            emit(ComicsPrevRes(ComicsSuccess(cachedComics)))
        }.catch { ComicsPrevRes(ComicsError(cachedComics)) }
    }

    private fun tryLocalSeries(id: Int): Flow<SeriesPrevRes> {
        return flow {
            emit(SeriesPrevRes(SeriesLoading(cachedSeries)))
            localDataSource.getSeries(id, seriesOffset).collect { cachedSeries.addAll(it) }
            emit(SeriesPrevRes(SeriesSuccess(cachedSeries)))
        }.catch { SeriesPrevRes(SeriesError(cachedSeries)) }
    }

    private fun tryLocalStories(id: Int): Flow<StoriesPrevRes> {
        return flow {
            emit(StoriesPrevRes(StoriesLoading(cachedStories)))
            localDataSource.getStories(id, storiesOffset).collect { cachedStories.addAll(it) }
            emit(StoriesPrevRes(StoriesSuccess(cachedStories)))
        }.catch { StoriesPrevRes(StoriesError(cachedStories)) }
    }

    private fun tryLocaleEvents(id: Int): Flow<EventsPrevRes> {
        return flow {
            emit(EventsPrevRes(EventsLoading(cachedEvents)))
            localDataSource.getEvents(id, eventsOffset).collect { cachedEvents.addAll(it) }
            emit(EventsPrevRes(EventsSuccess(cachedEvents)))
        }.catch { EventsPrevRes(EventsError(cachedEvents)) }
    }

}

data class Character(
    override val self: CharRes = CharRes(Loading()),
    override val comics: ComicsPrevRes = ComicsPrevRes(ComicsLoading()),
    override val series: SeriesPrevRes = SeriesPrevRes(SeriesLoading()),
    override val stories: StoriesPrevRes = StoriesPrevRes(StoriesLoading()),
    override val events: EventsPrevRes = EventsPrevRes(EventsLoading()),
) : Character
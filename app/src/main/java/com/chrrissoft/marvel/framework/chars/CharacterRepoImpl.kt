package com.chrrissoft.marvel.framework.chars

import androidx.compose.runtime.mutableStateListOf
import com.chrrissoft.marvel.data.chars.CharacterDataSource.LocalCharacterDataSource
import com.chrrissoft.marvel.data.chars.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.chars.CharsRepo
import com.chrrissoft.marvel.data.chars.CharsRepo.Source
import com.chrrissoft.marvel.data.chars.CharsRepo.Source.LOCAL
import com.chrrissoft.marvel.data.chars.CharsRepo.Source.REMOTE
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.framework.chars.datasource.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.transform
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

class CharacterRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteCharacterDataSource,
    private val localDataSource: LocalCharacterDataSource,
) : CharsRepo {

    private val cachedChars = mutableStateListOf<CharsPreview>()
    private val cachedComics = mutableStateListOf<ComicPreview>()
    private val cachedSeries = mutableStateListOf<SeriesPreview>()
    private val cachedStories = mutableStateListOf<StoriesPreview>()
    private val cachedEvents = mutableStateListOf<EventPreview>()

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

    private fun tryRemoteChars(): Flow<CharsPrevRes> {
        return try {
            remoteDataSource.getChars(charsOffset)
                .transform {
                    emit(CharsPrevRes(CharsLoading(cachedChars)))
                    emit(CharsPrevRes(CharsSuccess(it)))
                }
        } catch (e: Exception) { tryLocalChars() }
    }

    private fun tryRemoteComics(id: Int): Flow<ComicsPrevRes> {
        return try {
            remoteDataSource.getComics(id, comicsOffset)
                .transform {
                    emit(ComicsPrevRes(ComicsLoading(cachedComics)))
                    emit(ComicsPrevRes(ComicsSuccess(it)))
                }
        } catch (e: Exception) { tryLocaleComics(id) }
    }

    private fun tryRemoteSeries(id: Int): Flow<SeriesPrevRes> {
        return try {
            remoteDataSource.getSeries(id, seriesOffset)
                .transform {
                    emit(SeriesPrevRes(SeriesLoading(cachedSeries)))
                    emit(SeriesPrevRes(SeriesSuccess(it)))
                }
        } catch (e: Exception) { tryLocalSeries(id) }
    }

    private fun tryRemoteStories(id: Int): Flow<StoriesPrevRes> {
        return try {
            remoteDataSource.getStories(id, storiesOffset)
                .transform {
                    emit(StoriesPrevRes(StoriesLoading(cachedStories)))
                    emit(StoriesPrevRes(StoriesSuccess(it)))
                }
        } catch (e: Exception) { tryLocalStories(id) }
    }

    private fun tryRemoteEvents(id: Int): Flow<EventsPrevRes> {
        return try {
            remoteDataSource.getEvents(id, eventsOffset)
                .transform {
                    emit(EventsPrevRes(EventsLoading(cachedEvents)))
                    emit(EventsPrevRes(EventsSuccess(it)))
                }
        } catch (e: Exception) {
            tryLocaleEvents(id)
        }
    }


    /* *************************  Internal Locale Attempts  ************************* */

    private fun tryLocalChars(): Flow<CharsPrevRes> {
        return localDataSource.getChars(charsOffset)
            .transform {
                emit(CharsPrevRes(CharsLoading(cachedChars)))
                emit(CharsPrevRes(CharsSuccess(it)))
            }.catch { emit(CharsPrevRes(CharsError(cachedChars))) }
    }

    private fun tryLocaleComics(id: Int): Flow<ComicsPrevRes> {
        return localDataSource.getComics(id, comicsOffset)
            .transform {
                emit(ComicsPrevRes(ComicsLoading(cachedComics)))
                emit(ComicsPrevRes(ComicsSuccess(it)))
            }.catch { emit(ComicsPrevRes(ComicsError(cachedComics))) }
    }

    private fun tryLocalSeries(id: Int): Flow<SeriesPrevRes> {
        return localDataSource.getSeries(id, seriesOffset)
            .transform {
                emit(SeriesPrevRes(SeriesLoading(cachedSeries)))
                emit(SeriesPrevRes(SeriesSuccess(it)))
            }.catch { emit(SeriesPrevRes(SeriesError(cachedSeries))) }
    }

    private fun tryLocalStories(id: Int): Flow<StoriesPrevRes> {
        return localDataSource.getStories(id, storiesOffset)
            .transform {
                emit(StoriesPrevRes(StoriesLoading(cachedStories)))
                emit(StoriesPrevRes(StoriesSuccess(it)))
            }.catch { emit(StoriesPrevRes(StoriesError(cachedStories))) }
    }

    private fun tryLocaleEvents(id: Int): Flow<EventsPrevRes> {
        return localDataSource.getEvents(id, eventsOffset)
            .transform {
                emit(EventsPrevRes(EventsLoading(cachedEvents)))
                emit(EventsPrevRes(EventsSuccess(it)))
            }.catch { emit(EventsPrevRes(EventsError(cachedEvents))) }
    }

}
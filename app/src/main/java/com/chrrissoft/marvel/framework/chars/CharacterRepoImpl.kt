package com.chrrissoft.marvel.framework.chars

import com.chrrissoft.marvel.data.chars.CharacterDataSource.LocalCharacterDataSource
import com.chrrissoft.marvel.data.chars.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.chars.CharsRepo
import com.chrrissoft.marvel.data.chars.CharsRepo.Source
import com.chrrissoft.marvel.data.chars.CharsRepo.Source.LOCAL
import com.chrrissoft.marvel.data.chars.CharsRepo.Source.REMOTE
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState.Error as CharsError
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState.Error as ComicsError
import com.chrrissoft.marvel.data.events.res.EventsPrevResState.Error as EventsError
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState.Error as SeriesError
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState.Error as StoriesError
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.framework.chars.api.CharacterResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

class CharacterRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteCharacterDataSource,
    private val localDataSource: LocalCharacterDataSource,
) : CharsRepo {

    companion object {
        private const val TAG = "CharacterRepoImpl"
    }

    override fun get(id: Int, source: Source): Flow<CharsPreview> {
        return when (source) {
            REMOTE -> tryRemoteGet(id)
            LOCAL -> tryLocalGet(id)
        }
    }

    override fun getPreviews(source: Source): Flow<CharsPrevRes> {
        return when (source) {
            REMOTE -> tryRemotePreview()
            LOCAL -> tryLocalPreview()
        }
    }

    override fun getComics(id: Int, source: Source): Flow<ComicsPrevRes> {
        return when (source) {
            REMOTE -> tryRemoteComics(id)
            LOCAL -> tryLocaleComics(id)
        }
    }

    override fun getEvents(id: Int, source: Source): Flow<EventsPrevRes> {
        return when(source) {
            REMOTE -> tryRemoteEvents(id)
            LOCAL -> tryLocaleEvents(id)
        }
    }

    override fun getStories(id: Int, source: Source): Flow<StoriesPrevRes> {
        return when(source) {
            REMOTE -> tryRemoteStories(id)
            LOCAL -> tryLocaleStories(id)
        }
    }

    override fun getSeries(id: Int, source: Source): Flow<SeriesPrevRes> {
        return when(source) {
            REMOTE -> tryRemoteSeries(id)
            LOCAL -> tryLocaleSeries(id)
        }
    }


    /* *************************  Internal Remote Attempts  ************************* */

    private fun tryRemoteGet(id: Int) = try {
        remoteDataSource.get(id)
    } catch (e: Exception) {
        localDataSource.get(id)
    }

    private fun tryRemotePreview() = try {
        remoteDataSource.getPreviews()
    } catch (e: Exception) {
        localDataSource.getPreviews()
    }

    private fun tryRemoteComics(id: Int) = try {
        remoteDataSource.getComics(id)
    } catch (e: Exception) {
        localDataSource.getComics(id)
    }

    private fun tryRemoteEvents(id: Int) = try {
        remoteDataSource.getEvents(id)
    } catch (e: Exception) {
        localDataSource.getEvents(id)
    }

    private fun tryRemoteStories(id: Int) = try {
        remoteDataSource.getStories(id)
    } catch (e: Exception) {
        localDataSource.getStories(id)
    }

    private fun tryRemoteSeries(id: Int) = try {
        remoteDataSource.getSeries(id)
    } catch (e: Exception) {
        localDataSource.getSeries(id)
    }


    /* *************************  Internal Locale Attempts  ************************* */

    private fun tryLocalGet(id: Int) =
        localDataSource.get(id).catch { emit(CharacterResult.emptyResult) }

    private fun tryLocalPreview() = localDataSource.getPreviews()
        .catch { emit(CharsPrevRes(CharsError(emptyList()))) }

    private fun tryLocaleComics(id: Int) = localDataSource.getComics(id)
        .catch { emit(ComicsPrevRes(ComicsError(emptyList()))) }

    private fun tryLocaleEvents(id: Int) = localDataSource.getEvents(id)
        .catch { emit(EventsPrevRes(EventsError(emptyList()))) }

    private fun tryLocaleStories(id: Int) = localDataSource.getStories(id)
        .catch { emit(StoriesPrevRes(StoriesError(emptyList()))) }

    private fun tryLocaleSeries(id: Int) = localDataSource.getSeries(id)
        .catch { emit(SeriesPrevRes(SeriesError(emptyList()))) }
}
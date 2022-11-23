package com.chrrissoft.marvel.framework.chars.datasource

import androidx.compose.runtime.mutableStateListOf
import com.chrrissoft.marvel.data.chars.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.chars.Character
import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.framework.chars.api.CharacterResult
import com.chrrissoft.marvel.framework.chars.api.CharsAPIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState.Loading as CharsLoading
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState.Success as CharsSuccess
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState.Loading as ComicsLoading
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState.Success as ComicsSuccess
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState.Loading as SeriesLoading
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState.Success as SeriesSuccess
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState.Loading as StoriesLoading
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState.Success as StoriesSuccess
import com.chrrissoft.marvel.data.events.res.EventsPrevResState.Loading as EventsLoading
import com.chrrissoft.marvel.data.events.res.EventsPrevResState.Success as EventsSuccess

class RemoteCharacterDataSourceImp @Inject constructor(
    private val api: CharsAPIService
) : RemoteCharacterDataSource {

    companion object {
        private const val TAG = "RemoteCharacterDataSourceImp"
    }

    private val cachedChars = mutableStateListOf<CharsPreview>()
    private val cachedComics = mutableStateListOf<ComicPreview>()
    private val cachedSeries = mutableStateListOf<SeriesPreview>()
    private val cachedStories = mutableStateListOf<StoriesPreview>()
    private val cachedEvents = mutableStateListOf<EventPreview>()

    var previewSize = cachedChars.size
    var comicsSize = cachedComics.size
    var seriesSize = cachedSeries.size
    var storiesSize = cachedStories.size
    var eventsSize = cachedEvents.size

    private var previewOffset = 0
    private var comicsOffset = 0
    private var eventsOffset = 0
    private var seriesOffset = 0
    private var storiesOffset = 0

    override fun get(id: Int): Flow<CharsPreview> {
        return flow {
            val result: CharsPreview = cachedChars.find { it.id == id }
                ?: CharacterResult.emptyResult
            emit(result)
        }
    }

    override fun getPreviews(): Flow<CharsPrevRes> {
        return flow {
            emit(CharsPrevRes(CharsLoading(cachedChars)))
            val apiResult = api.getPreview(previewOffset).body()?.data?.results ?: emptyList()
            emit(CharsPrevRes(CharsSuccess(apiResult)))
            cachedChars.addAll(apiResult)
            updateComicsOffset()
            updateComicsSize()
        }
    }

    override fun getComics(id: Int): Flow<ComicsPrevRes> {
        return flow {
            emit(ComicsPrevRes(ComicsLoading(cachedComics)))
            val apiResult = api.getComics(id, previewOffset).body()?.data?.results ?: emptyList()
            emit(ComicsPrevRes(ComicsSuccess(apiResult)))
            cachedComics.addAll(apiResult)
            updatePreviewOffset()
            updatePreviewSize()
        }
    }

    override fun getSeries(id: Int): Flow<SeriesPrevRes> {
        return flow {
            emit(SeriesPrevRes(SeriesLoading(cachedSeries)))
            val apiResult = api.getSeries(id, previewOffset).body()?.data?.results ?: emptyList()
            emit(SeriesPrevRes(SeriesSuccess(apiResult)))
            cachedSeries.addAll(apiResult)
            updateSeriesOffset()
            updateSeriesSize()
        }
    }

    override fun getStories(id: Int): Flow<StoriesPrevRes> {
        return flow {
            emit(StoriesPrevRes(StoriesLoading(cachedStories)))
            val apiResult = api.getStories(id, previewOffset).body()?.data?.results ?: emptyList()
            emit(StoriesPrevRes(StoriesSuccess(apiResult)))
            cachedStories.addAll(apiResult)
            updateStoriesOffset()
            updateStoriesSize()
        }
    }

    override fun getEvents(id: Int): Flow<EventsPrevRes> {
        return flow {
            emit(EventsPrevRes(EventsLoading(cachedEvents)))
            val apiResult = api.getEvents(id, previewOffset).body()?.data?.results ?: emptyList()
            emit(EventsPrevRes(EventsSuccess(apiResult)))
            cachedEvents.addAll(apiResult)
            updateEventsOffset()
            updateEventsSize()
        }
    }

    
    private fun updatePreviewOffset() {
        previewOffset += 20
    }

    private fun updateComicsOffset() {
        comicsOffset += 20
    }

    private fun updateSeriesOffset() {
        seriesOffset += 20
    }

    private fun updateEventsOffset() {
        eventsOffset += 20
    }

    private fun updateStoriesOffset() {
        storiesOffset += 20
    }
    

    private fun updatePreviewSize() {
        previewSize += 20
    }

    private fun updateComicsSize() {
        comicsSize += 20
    }

    private fun updateSeriesSize() {
        seriesSize += 20
    }

    private fun updateEventsSize() {
        eventsSize += 20
    }

    private fun updateStoriesSize() {
        storiesSize += 20
    }
    
    
}


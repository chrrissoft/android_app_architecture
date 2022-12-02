package com.chrrissoft.marvel.framework.series.datasource

import com.chrrissoft.marvel.data.series.SeriesDataSource.RemoteSeriesDataSource
import com.chrrissoft.marvel.framework.chars.datasource.CharsOffset
import com.chrrissoft.marvel.framework.comics.datasource.ComicsOffset
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.series.api.SeriesAPIService
import com.chrrissoft.marvel.framework.stories.datasource.StoriesOffset
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteSeriesDataSourceImp @Inject constructor(
    private val api: SeriesAPIService
) : RemoteSeriesDataSource {

    override fun getChars(id: Int, offset: CharsOffset) = flow {
        val apiResult = api.getChars(id, offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

    override fun getComics(id: Int, offset: ComicsOffset) = flow {
        val apiResult = api.getComics(id, offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

    override fun getSeries(offset: SeriesOffset) = flow {
        val apiResult = api.getSeries(offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

    override fun getStories(id: Int, offset: StoriesOffset) = flow {
        val apiResult = api.getStories(id, offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

    override fun getEvents(id: Int, offset: EventsOffset) = flow {
        val apiResult = api.getEvents(id, offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

}

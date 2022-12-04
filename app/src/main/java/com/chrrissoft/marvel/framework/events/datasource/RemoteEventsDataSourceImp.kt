package com.chrrissoft.marvel.framework.events.datasource

import com.chrrissoft.marvel.data.events.EventsDataSource.RemoteEventsDataSource
import com.chrrissoft.marvel.framework.chars.datasource.CharsOffset
import com.chrrissoft.marvel.framework.comics.datasource.ComicsOffset
import com.chrrissoft.marvel.framework.events.api.EventsAPIService
import com.chrrissoft.marvel.framework.series.datasource.SeriesOffset
import com.chrrissoft.marvel.framework.stories.datasource.StoriesOffset
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteEventsDataSourceImp @Inject constructor(
    private val api: EventsAPIService
) : RemoteEventsDataSource {

    override fun getEvent(id: Int) = flow {
        val apiResult = api.getEvent(id).body()?.data?.results ?: emptyList()
        val result = apiResult.first { it.id == id }
        emit(result)
    }

    override fun getChars(id: Int, offset: CharsOffset) = flow {
        val apiResult = api.getChars(id, offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

    override fun getComics(id: Int, offset: ComicsOffset) = flow {
        val apiResult = api.getComics(id, offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

    override fun getSeries(id: Int, offset: SeriesOffset) = flow {
        val apiResult = api.getSeries(id, offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

    override fun getStories(id: Int, offset: StoriesOffset) = flow {
        val apiResult = api.getStories(id, offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

    override fun getEvents(offset: EventsOffset) = flow {
        val apiResult = api.getEvents(offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

}

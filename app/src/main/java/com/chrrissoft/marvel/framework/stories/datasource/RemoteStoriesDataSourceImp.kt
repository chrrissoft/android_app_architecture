package com.chrrissoft.marvel.framework.stories.datasource

import com.chrrissoft.marvel.data.stories.StoriesDataSource.RemoteStoriesDataSource
import com.chrrissoft.marvel.framework.chars.datasource.CharsOffset
import com.chrrissoft.marvel.framework.comics.datasource.ComicsOffset
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.series.datasource.SeriesOffset
import com.chrrissoft.marvel.framework.stories.api.StoriesAPIService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteStoriesDataSourceImp @Inject constructor(
    private val api: StoriesAPIService
) : RemoteStoriesDataSource {

    override fun getStory(id: Int) = flow {
        val apiResult = api.getStory(id).body()?.data?.results ?: emptyList()
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

    override fun getStories(offset: StoriesOffset) = flow {
        val apiResult = api.getStories(offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

    override fun getEvents(id: Int, offset: EventsOffset) = flow {
        val apiResult = api.getEvents(id, offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

}

package com.chrrissoft.marvel.framework.comics.datasource

import com.chrrissoft.marvel.data.comics.ComicsDataSource.RemoteComicsDataSource
import com.chrrissoft.marvel.framework.chars.datasource.CharsOffset
import com.chrrissoft.marvel.framework.comics.api.ComicsAPIService
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.series.datasource.SeriesOffset
import com.chrrissoft.marvel.framework.stories.datasource.StoriesOffset
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteComicsDataSourceImp @Inject constructor(
    private val api: ComicsAPIService
) : RemoteComicsDataSource {

    override fun getComic(id: Int) = flow {
        val apiResult = api.getComic(id).body()?.data?.results ?: emptyList()
        val result = apiResult.first { it.id == id }
        emit(result)

    }

    override fun getChars(id: Int, offset: CharsOffset) = flow {
        val apiResult = api.getChars(id, offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

    override fun getComics(offset: ComicsOffset) = flow {
        val apiResult = api.getComics(offset.value).body()?.data?.results ?: emptyList()
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

    override fun getEvents(id: Int, offset: EventsOffset) = flow {
        val apiResult = api.getEvents(id, offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

}

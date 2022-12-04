package com.chrrissoft.marvel.framework.chars.datasource

import com.chrrissoft.marvel.data.chars.CharsDataSource.RemoteCharsDataSource
import com.chrrissoft.marvel.framework.chars.api.CharsAPIService
import com.chrrissoft.marvel.framework.comics.datasource.ComicsOffset
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.series.datasource.SeriesOffset
import com.chrrissoft.marvel.framework.stories.datasource.StoriesOffset
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteCharsDataSourceImp @Inject constructor(
    private val api: CharsAPIService
) : RemoteCharsDataSource {

    override fun getChar(id: Int) = flow {
        val apiResult = api.getChars(130).body()?.data?.results ?: emptyList()
        val result = apiResult.first { it.id == id }
        emit(result)
    }

    override fun getChars(offset: CharsOffset) = flow {
        val apiResult = api.getChars(130).body()?.data?.results ?: emptyList()
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

    override fun getEvents(id: Int, offset: EventsOffset) = flow {
        val apiResult = api.getEvents(id, offset.value).body()?.data?.results ?: emptyList()
        emit(apiResult)
    }

}

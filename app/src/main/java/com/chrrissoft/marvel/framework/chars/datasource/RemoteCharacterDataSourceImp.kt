package com.chrrissoft.marvel.framework.chars.datasource

import com.chrrissoft.marvel.data.chars.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.framework.chars.api.CharsAPIService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteCharacterDataSourceImp @Inject constructor(
    private val api: CharsAPIService
) : RemoteCharacterDataSource {

    companion object {
        private const val TAG = "RemoteCharacterDataSourceImp"
    }

    override fun getChars(offset: CharsOffset) = flow {
        val apiResult = api.getPreview(offset.value).body()?.data?.results ?: emptyList()
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

@JvmInline
value class CharsOffset(val value: Int = 0) {
    fun copy(value: Int) = SeriesOffset(value)
}

@JvmInline
value class ComicsOffset(val value: Int = 0) {
    fun copy(value: Int) = SeriesOffset(value)
}

@JvmInline
value class SeriesOffset(val value: Int = 0) {
    fun copy(value: Int) = SeriesOffset(value)
}

@JvmInline
value class StoriesOffset(val value: Int = 0) {
    fun copy(value: Int) = SeriesOffset(value)
}

@JvmInline
value class EventsOffset(val value: Int = 0) {
    fun copy(value: Int) = SeriesOffset(value)
}

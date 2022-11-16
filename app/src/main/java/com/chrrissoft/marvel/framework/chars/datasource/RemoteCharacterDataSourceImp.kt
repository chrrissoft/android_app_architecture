package com.chrrissoft.marvel.framework.chars.datasource

import com.chrrissoft.marvel.data.chars.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState.Loading as CharsLoading
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState.Success as CharsSuccess
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState.Error as CharsError
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.framework.chars.api.CharacterAPIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteCharacterDataSourceImp @Inject constructor(
    private val api: CharacterAPIService
) : RemoteCharacterDataSource {

    private val cachePreview = mutableListOf<CharsPreview>()

    override fun getPreviews(): Flow<CharsPrevRes> {
        return flow {
            try {
                emit(CharsPrevRes(CharsLoading(cachePreview)))
                val apiResult = api.getPreview().body()?.data?.results ?: emptyList()
                emit(CharsPrevRes(CharsSuccess(apiResult)))
                cachePreview.addAll(apiResult)
            } catch (e: Exception) {
                emit(CharsPrevRes(CharsError(e, cachePreview)))
            }
        }
    }

    override fun getComics(): Flow<ComicsPrevRes> {
        return emptyFlow()
    }

    override fun getSeries(): Flow<SeriesPrevRes> {
        return emptyFlow()
    }

    override fun getStories(): Flow<StoriesPrevRes> {
        return emptyFlow()
    }

    override fun getEvents(): Flow<EventsPrevRes> {
        return emptyFlow()
    }

}


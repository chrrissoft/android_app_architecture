package com.chrrissoft.marvel.framework.characters.datasource

import com.chrrissoft.marvel.data.characters.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.data.characters.CharacterResponse
import com.chrrissoft.marvel.data.characters.CharsPrevResState
import com.chrrissoft.marvel.data.characters.CharsPrevResState.*
import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import com.chrrissoft.marvel.framework.characters.api.CharacterAPIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteCharacterDataSourceImp @Inject constructor(
    private val api: CharacterAPIService
) : RemoteCharacterDataSource {

    override fun getPreviews(): Flow<CharsPrevResponse> = flow {
        try {
            emit(CharsPrevResponse(CharsPrevLoading()))

            val apiResult = api.getPreview().body()?.data?.results ?: emptyList()

            emit(CharsPrevResponse(CharsPrevSuccess(apiResult)))

        } catch (e: Exception) {
            emit(CharsPrevResponse(CharsPrevError(e)))
        }
    }

    override fun getComics(): Flow<ComicsPrevResponse> {
        TODO("Not yet implemented")
    }

    override fun getSeries(): Flow<SeriesPrevResponse> {
        TODO("Not yet implemented")
    }

    override fun getStories(): Flow<StoriesPrevResponse> {
        TODO("Not yet implemented")
    }

    override fun getEvents(): Flow<EventsPrevResponse> {
        TODO("Not yet implemented")
    }

}
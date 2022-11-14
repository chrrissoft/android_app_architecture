package com.chrrissoft.marvel.framework.characters.datasource

import com.chrrissoft.marvel.data.characters.CharacterDataSource.LocalCharacterDataSource
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalCharacterDataSourceImpl @Inject constructor(

) : LocalCharacterDataSource {

    override fun getPreviews(): Flow<CharacterPreviewResponse> {
        TODO("Not yet implemented")
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

    override fun getEvents(): Flow<EventsPreviewResponse> {
        TODO("Not yet implemented")
    }

}







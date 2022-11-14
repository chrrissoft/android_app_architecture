package com.chrrissoft.marvel.framework.stories.datasource

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesDataSource.LocalStoriesDataSource
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalStoriesDataSourceImpl @Inject constructor(

) : LocalStoriesDataSource {

    override fun getComics(): Flow<ComicsPrevResponse> {
        TODO("Not yet implemented")
    }

    override fun getEvents(): Flow<EventsPrevResponse> {
        TODO("Not yet implemented")
    }

    override fun getPreview(): Flow<StoriesPrevResponse> {
        TODO("Not yet implemented")
    }

    override fun getCharacters(): Flow<CharsPrevResponse> {
        TODO("Not yet implemented")
    }

    override fun getSeries(): Flow<SeriesPrevResponse> {
        TODO("Not yet implemented")
    }


}







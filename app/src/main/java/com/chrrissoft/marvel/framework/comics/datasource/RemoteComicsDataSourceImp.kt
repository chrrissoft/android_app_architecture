package com.chrrissoft.marvel.framework.comics.datasource

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsDataSource.RemoteComicsDataSource
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteComicsDataSourceImp @Inject constructor(
) : RemoteComicsDataSource {

    override fun getPreview(): Flow<ComicsPrevResponse> {
        TODO("Not yet implemented")
    }

    override fun getCharacters(): Flow<CharsPrevResponse> {
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

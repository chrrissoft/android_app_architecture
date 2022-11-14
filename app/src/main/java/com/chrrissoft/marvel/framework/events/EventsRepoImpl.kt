package com.chrrissoft.marvel.framework.events

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventResponse
import com.chrrissoft.marvel.data.events.EventsDataSource.LocalEventsDataSource
import com.chrrissoft.marvel.data.events.EventsDataSource.RemoteEventsDataSource
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.events.EventsRepo
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import javax.inject.Inject

class EventsRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteEventsDataSource,
    private val localDataSource: LocalEventsDataSource,
) : EventsRepo {

    private companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getFromLocal(): EventResponse {
        TODO("Not yet implemented")
    }

    override fun getFromRemote(): EventResponse {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromRemote(): EventsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromLocal(): EventsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getComicsFromRemote(): ComicsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getComicsFromLocal(): ComicsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getStoriesFromRemote(): StoriesPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getStoriesFromLocal(): StoriesPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getCharactersFromRemote(): CharsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getCharactersFromLocal(): CharsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getSeriesFromRemote(): SeriesPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getSeriesFromLocal(): SeriesPrevResponse {
        TODO("Not yet implemented")
    }


}
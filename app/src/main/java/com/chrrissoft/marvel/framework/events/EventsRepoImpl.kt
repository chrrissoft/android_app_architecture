package com.chrrissoft.marvel.framework.events

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.events.EventsDataSource.LocalEventsDataSource
import com.chrrissoft.marvel.data.events.EventsDataSource.RemoteEventsDataSource
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.events.EventsRepo
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import javax.inject.Inject

class EventsRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteEventsDataSource,
    private val localDataSource: LocalEventsDataSource,
) : EventsRepo {

    private companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getFromLocal(): EventRes {
        TODO("Not yet implemented")
    }

    override fun getFromRemote(): EventRes {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromRemote(): EventsPrevRes {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromLocal(): EventsPrevRes {
        TODO("Not yet implemented")
    }

    override fun getComicsFromRemote(): ComicsPrevRes {
        TODO("Not yet implemented")
    }

    override fun getComicsFromLocal(): ComicsPrevRes {
        TODO("Not yet implemented")
    }

    override fun getStoriesFromRemote(): StoriesPrevRes {
        TODO("Not yet implemented")
    }

    override fun getStoriesFromLocal(): StoriesPrevRes {
        TODO("Not yet implemented")
    }

    override fun getCharactersFromRemote(): CharsPrevRes {
        TODO("Not yet implemented")
    }

    override fun getCharactersFromLocal(): CharsPrevRes {
        TODO("Not yet implemented")
    }

    override fun getSeriesFromRemote(): SeriesPrevRes {
        TODO("Not yet implemented")
    }

    override fun getSeriesFromLocal(): SeriesPrevRes {
        TODO("Not yet implemented")
    }


}
package com.chrrissoft.marvel.framework.stories

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesDataSource.LocalStoriesDataSource
import com.chrrissoft.marvel.data.stories.StoriesDataSource.RemoteStoriesDataSource
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesRepo
import com.chrrissoft.marvel.data.stories.StoriesResponse
import javax.inject.Inject

class StoriesRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteStoriesDataSource,
    private val localDataSource: LocalStoriesDataSource,
) : StoriesRepo {

    private companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getFromLocal(): StoriesResponse {
        TODO("Not yet implemented")
    }

    override fun getFromRemote(): StoriesResponse {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromRemote(): StoriesPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromLocal(): StoriesPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getEventsFromRemote(): EventsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getEventsFromLocal(): EventsPrevResponse {
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

    override fun getComicsFromRemote(): ComicsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getComicsFromLocal(): ComicsPrevResponse {
        TODO("Not yet implemented")
    }

}
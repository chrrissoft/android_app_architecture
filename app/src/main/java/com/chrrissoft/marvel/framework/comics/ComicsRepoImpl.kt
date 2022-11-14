package com.chrrissoft.marvel.framework.comics

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsDataSource.LocalComicsDataSource
import com.chrrissoft.marvel.data.comics.ComicsDataSource.RemoteComicsDataSource
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsRepo
import com.chrrissoft.marvel.data.comics.ComicsResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import javax.inject.Inject

class ComicsRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteComicsDataSource,
    private val localDataSource: LocalComicsDataSource,
) : ComicsRepo {

    companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getFromLocal(): ComicsResponse {
        TODO("Not yet implemented")
    }

    override fun getFromRemote(): ComicsResponse {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromRemote(): ComicsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromLocal(): ComicsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getEventsFromRemote(): EventsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getEventsFromLocal(): EventsPrevResponse {
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
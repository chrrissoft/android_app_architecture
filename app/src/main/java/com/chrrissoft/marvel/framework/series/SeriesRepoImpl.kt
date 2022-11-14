package com.chrrissoft.marvel.framework.series

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesDataSource.LocalSeriesDataSource
import com.chrrissoft.marvel.data.series.SeriesDataSource.RemoteSeriesDataSource
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.series.SeriesRepo
import com.chrrissoft.marvel.data.series.SeriesResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import javax.inject.Inject

class SeriesRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteSeriesDataSource,
    private val localDataSource: LocalSeriesDataSource,
) : SeriesRepo {

    private companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getFromLocal(): SeriesResponse {
        TODO("Not yet implemented")
    }

    override fun getFromRemote(): SeriesResponse {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromRemote(): SeriesPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromLocal(): SeriesPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getComicsFromRemote(): ComicsPrevResponse {
        TODO("Not yet implemented")
    }

    override fun getComicsFromLocal(): ComicsPrevResponse {
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


}
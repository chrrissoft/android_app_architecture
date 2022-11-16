package com.chrrissoft.marvel.framework.series

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.SeriesDataSource.LocalSeriesDataSource
import com.chrrissoft.marvel.data.series.SeriesDataSource.RemoteSeriesDataSource
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.SeriesRepo
import com.chrrissoft.marvel.data.series.res.SerieRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import javax.inject.Inject

class SeriesRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteSeriesDataSource,
    private val localDataSource: LocalSeriesDataSource,
) : SeriesRepo {

    private companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getFromLocal(): SerieRes {
        TODO("Not yet implemented")
    }

    override fun getFromRemote(): SerieRes {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromRemote(): SeriesPrevRes {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromLocal(): SeriesPrevRes {
        TODO("Not yet implemented")
    }

    override fun getComicsFromRemote(): ComicsPrevRes {
        TODO("Not yet implemented")
    }

    override fun getComicsFromLocal(): ComicsPrevRes {
        TODO("Not yet implemented")
    }

    override fun getEventsFromRemote(): EventsPrevRes {
        TODO("Not yet implemented")
    }

    override fun getEventsFromLocal(): EventsPrevRes {
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


}
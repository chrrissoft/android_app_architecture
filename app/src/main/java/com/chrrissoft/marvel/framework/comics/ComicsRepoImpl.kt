package com.chrrissoft.marvel.framework.comics

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.ComicsDataSource.LocalComicsDataSource
import com.chrrissoft.marvel.data.comics.ComicsDataSource.RemoteComicsDataSource
import com.chrrissoft.marvel.data.comics.ComicsRepo
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import javax.inject.Inject

class ComicsRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteComicsDataSource,
    private val localDataSource: LocalComicsDataSource,
) : ComicsRepo {

    companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getFromLocal(): ComicRes {
        TODO("Not yet implemented")
    }

    override fun getFromRemote(): ComicRes {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromRemote(): ComicsPrevRes {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromLocal(): ComicsPrevRes {
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

    override fun getSeriesFromRemote(): SeriesPrevRes {
        TODO("Not yet implemented")
    }

    override fun getSeriesFromLocal(): SeriesPrevRes {
        TODO("Not yet implemented")
    }

}
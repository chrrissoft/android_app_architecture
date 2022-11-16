package com.chrrissoft.marvel.framework.stories

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.StoriesDataSource.LocalStoriesDataSource
import com.chrrissoft.marvel.data.stories.StoriesDataSource.RemoteStoriesDataSource
import com.chrrissoft.marvel.data.stories.StoriesRepo
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoryRes
import javax.inject.Inject

class StoriesRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteStoriesDataSource,
    private val localDataSource: LocalStoriesDataSource,
) : StoriesRepo {

    private companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getFromLocal(): StoryRes {
        TODO("Not yet implemented")
    }

    override fun getFromRemote(): StoryRes {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromRemote(): StoriesPrevRes {
        TODO("Not yet implemented")
    }

    override fun getPreviewFromLocal(): StoriesPrevRes {
        TODO("Not yet implemented")
    }

    override fun getEventsFromRemote(): EventsPrevRes {
        TODO("Not yet implemented")
    }

    override fun getEventsFromLocal(): EventsPrevRes {
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

    override fun getComicsFromRemote(): ComicsPrevRes {
        TODO("Not yet implemented")
    }

    override fun getComicsFromLocal(): ComicsPrevRes {
        TODO("Not yet implemented")
    }

}
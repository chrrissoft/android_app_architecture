package com.chrrissoft.marvel.framework.stories

import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SerieRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.StoriesDataSource.LocalStoriesDataSource
import com.chrrissoft.marvel.data.stories.StoriesDataSource.RemoteStoriesDataSource
import com.chrrissoft.marvel.data.stories.StoriesRepo
import com.chrrissoft.marvel.data.stories.Story
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoryRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class StoriesRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteStoriesDataSource,
    private val localDataSource: LocalStoriesDataSource,
) : StoriesRepo {

    private companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getInfo(
        id: Int,
        requestOf: StoriesRepo.RequestOf,
        source: StoriesRepo.Source
    ): Flow<Story> {
        return emptyFlow()
    }

    override fun getPreviews(source: StoriesRepo.Source): Flow<StoriesPrevRes> {
        return emptyFlow()
    }


}
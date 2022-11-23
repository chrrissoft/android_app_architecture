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

    override fun get(source: StoriesRepo.Source): Flow<StoryRes> {
        return emptyFlow()
    }

    override fun getPreviews(source: StoriesRepo.Source): Flow<StoriesPrevRes> {
        return emptyFlow()
    }

    override fun getChars(source: StoriesRepo.Source): Flow<CharsPrevRes> {
        return emptyFlow()
    }

    override fun geChar(source: StoriesRepo.Source): Flow<CharRes> {
        return emptyFlow()
    }

    override fun getComics(source: StoriesRepo.Source): Flow<ComicsPrevRes> {
        return emptyFlow()
    }

    override fun getComic(source: StoriesRepo.Source): Flow<ComicRes> {
        return emptyFlow()
    }

    override fun getStories(source: StoriesRepo.Source): Flow<SeriesPrevRes> {
        return emptyFlow()
    }

    override fun getStory(source: StoriesRepo.Source): Flow<SerieRes> {
        return emptyFlow()
    }

    override fun getEvents(source: StoriesRepo.Source): Flow<EventsPrevRes> {
        return emptyFlow()
    }

    override fun getEvent(source: StoriesRepo.Source): Flow<EventRes> {
        return emptyFlow()
    }
}
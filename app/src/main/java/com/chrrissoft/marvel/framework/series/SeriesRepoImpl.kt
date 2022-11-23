package com.chrrissoft.marvel.framework.series

import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.SeriesDataSource.LocalSeriesDataSource
import com.chrrissoft.marvel.data.series.SeriesDataSource.RemoteSeriesDataSource
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.SeriesRepo
import com.chrrissoft.marvel.data.series.res.SerieRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoryRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class SeriesRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteSeriesDataSource,
    private val localDataSource: LocalSeriesDataSource,
) : SeriesRepo {

    private companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun get(source: SeriesRepo.Source): Flow<SerieRes> {
        return emptyFlow()
    }

    override fun getPreviews(source: SeriesRepo.Source): Flow<SeriesPrevRes> {
        return emptyFlow()
    }

    override fun getChars(source: SeriesRepo.Source): Flow<CharsPrevRes> {
        return emptyFlow()
    }

    override fun geChar(source: SeriesRepo.Source): Flow<CharRes> {
        return emptyFlow()
    }

    override fun getComics(source: SeriesRepo.Source): Flow<ComicsPrevRes> {
        return emptyFlow()
    }

    override fun getComic(source: SeriesRepo.Source): Flow<ComicRes> {
        return emptyFlow()
    }

    override fun getStories(source: SeriesRepo.Source): Flow<StoriesPrevRes> {
        return emptyFlow()
    }

    override fun getStory(source: SeriesRepo.Source): Flow<StoryRes> {
        return emptyFlow()
    }

    override fun getEvents(source: SeriesRepo.Source): Flow<EventsPrevRes> {
        return emptyFlow()
    }

    override fun getEvent(source: SeriesRepo.Source): Flow<EventRes> {
        return emptyFlow()
    }

}
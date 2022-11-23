package com.chrrissoft.marvel.framework.comics

import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.ComicsDataSource.LocalComicsDataSource
import com.chrrissoft.marvel.data.comics.ComicsDataSource.RemoteComicsDataSource
import com.chrrissoft.marvel.data.comics.ComicsRepo
import com.chrrissoft.marvel.data.comics.ComicsRepo.Source
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SerieRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoryRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class ComicsRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteComicsDataSource,
    private val localDataSource: LocalComicsDataSource,
) : ComicsRepo {

    companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun get(source: Source): Flow<ComicRes> {
        return emptyFlow()
    }

    override fun getPreviews(source: Source): Flow<ComicsPrevRes> {
        return remoteDataSource.getPreview()
    }

    override fun getChars(source: Source): Flow<CharsPrevRes> {
        return emptyFlow()
    }

    override fun geChar(source: Source): Flow<CharRes> {
        return emptyFlow()
    }

    override fun getEvents(source: Source): Flow<EventsPrevRes> {
        return emptyFlow()
    }

    override fun getEvent(source: Source): Flow<EventRes> {
        return emptyFlow()
    }

    override fun getStories(source: Source): Flow<StoriesPrevRes> {
        return emptyFlow()
    }

    override fun getStory(source: Source): Flow<StoryRes> {
        return emptyFlow()
    }

    override fun getSeries(source: Source): Flow<SeriesPrevRes> {
        return emptyFlow()
    }

    override fun getSerie(source: Source): Flow<SerieRes> {
        return emptyFlow()
    }

}
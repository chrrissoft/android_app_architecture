package com.chrrissoft.marvel.framework.chars

import com.chrrissoft.marvel.data.chars.CharacterDataSource.LocalCharacterDataSource
import com.chrrissoft.marvel.data.chars.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.data.chars.CharsRepo
import com.chrrissoft.marvel.data.chars.Source
import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
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

class CharacterRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteCharacterDataSource,
    private val localDataSource: LocalCharacterDataSource,
) : CharsRepo {

    companion object {
        private const val TAG = "CharacterRepoImpl"
    }

    override fun get(source: Source): Flow<CharRes> {
        return emptyFlow()
    }

    override fun getPreviews(source: Source): Flow<CharsPrevRes> {
        return remoteDataSource.getPreviews()
    }

    override fun getComics(source: Source): Flow<ComicsPrevRes> {
        return emptyFlow()
    }

    override fun getComic(source: Source): Flow<ComicRes> {
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
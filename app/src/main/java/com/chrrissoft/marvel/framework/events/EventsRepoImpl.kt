package com.chrrissoft.marvel.framework.events

import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.events.EventsDataSource.LocalEventsDataSource
import com.chrrissoft.marvel.data.events.EventsDataSource.RemoteEventsDataSource
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.events.EventsRepo
import com.chrrissoft.marvel.data.series.res.SerieRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoryRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class EventsRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteEventsDataSource,
    private val localDataSource: LocalEventsDataSource,
) : EventsRepo {

    private companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun get(source: EventsRepo.Source): Flow<EventRes> {
        return emptyFlow()
    }

    override fun getPreviews(source: EventsRepo.Source): Flow<EventsPrevRes> {
        return remoteDataSource.getPreviews()
    }

    override fun getChars(source: EventsRepo.Source): Flow<CharsPrevRes> {
        return emptyFlow()
    }

    override fun geChar(source: EventsRepo.Source): Flow<CharRes> {
        return emptyFlow()
    }

    override fun getComics(source: EventsRepo.Source): Flow<ComicsPrevRes> {
        return emptyFlow()
    }

    override fun getComic(source: EventsRepo.Source): Flow<ComicRes> {
        return emptyFlow()
    }

    override fun getStories(source: EventsRepo.Source): Flow<StoriesPrevRes> {
        return emptyFlow()
    }

    override fun getStory(source: EventsRepo.Source): Flow<StoryRes> {
        return emptyFlow()
    }

    override fun getSeries(source: EventsRepo.Source): Flow<SeriesPrevRes> {
        return emptyFlow()
    }

    override fun getSerie(source: EventsRepo.Source): Flow<SerieRes> {
        return emptyFlow()
    }

}
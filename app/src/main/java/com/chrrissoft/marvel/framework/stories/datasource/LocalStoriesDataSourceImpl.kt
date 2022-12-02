package com.chrrissoft.marvel.framework.stories.datasource

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.StoriesDataSource.LocalStoriesDataSource
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class LocalStoriesDataSourceImpl @Inject constructor(

) : LocalStoriesDataSource {

    override fun getComics(): Flow<ComicsPrevRes> {
        return emptyFlow()
    }

    override fun getEvents(): Flow<EventsPrevRes> {
        return emptyFlow()
    }

    override fun getStories(): Flow<StoriesPrevRes> {
        return emptyFlow()
    }

    override fun getChars(): Flow<CharsPrevRes> {
        return emptyFlow()
    }

    override fun getSeries(): Flow<SeriesPrevRes> {
        return emptyFlow()
    }


}







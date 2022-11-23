package com.chrrissoft.marvel.framework.stories.datasource

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.StoriesDataSource
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.framework.stories.api.StoriesAPIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class RemoteStoriesDataSourceImp @Inject constructor(
    private val api: StoriesAPIService
) : StoriesDataSource.RemoteStoriesDataSource {

    override fun getComics(): Flow<ComicsPrevRes> {
        return emptyFlow()
    }

    override fun getPreview(): Flow<StoriesPrevRes> {
        return emptyFlow()
    }

    override fun getCharacters(): Flow<CharsPrevRes> {
        return emptyFlow()
    }

    override fun getSeries(): Flow<SeriesPrevRes> {
        return emptyFlow()
    }

    override fun getEvents(): Flow<EventsPrevRes> {
        return emptyFlow()
    }

}
package com.chrrissoft.marvel.framework.events.datasource

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.EventsDataSource.RemoteEventsDataSource
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteEventsDataSourceImp @Inject constructor(
) : RemoteEventsDataSource {
    override fun getPreviews(): Flow<EventsPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getCharacters(): Flow<CharsPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getSeries(): Flow<SeriesPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getStories(): Flow<StoriesPrevRes> {
        TODO("Not yet implemented")
    }

    override fun getComics(): Flow<ComicsPrevRes> {
        TODO("Not yet implemented")
    }

}

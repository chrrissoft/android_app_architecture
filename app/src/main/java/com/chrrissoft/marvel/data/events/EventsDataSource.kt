package com.chrrissoft.marvel.data.events

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow

interface EventsDataSource {

    fun getPreviews() : Flow<EventsPrevRes>

    fun getCharacters() : Flow<CharsPrevRes>

    fun getSeries() : Flow<SeriesPrevRes>

    fun getComics() : Flow<ComicsPrevRes>

    fun getStories() : Flow<StoriesPrevRes>

    interface LocalEventsDataSource : EventsDataSource
    interface RemoteEventsDataSource : EventsDataSource

    // add another data source type is easy
    // ...

}
package com.chrrissoft.marvel.data.events

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import kotlinx.coroutines.flow.Flow

interface EventsDataSource {

    fun getPreviews() : Flow<EventsPrevResponse>

    fun getCharacters() : Flow<CharsPrevResponse>

    fun getSeries() : Flow<SeriesPrevResponse>

    fun getComics() : Flow<ComicsPrevResponse>

    fun getStories() : Flow<StoriesPrevResponse>

    interface LocalEventsDataSource : EventsDataSource
    interface RemoteEventsDataSource : EventsDataSource

    // add another data source type is easy
    // ...

}
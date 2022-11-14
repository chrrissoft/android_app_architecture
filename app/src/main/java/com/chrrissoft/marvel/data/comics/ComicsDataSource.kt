package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import kotlinx.coroutines.flow.Flow

interface ComicsDataSource {

    fun getPreview() : Flow<ComicsPrevResponse>

    fun getCharacters() : Flow<CharsPrevResponse>

    fun getSeries() : Flow<SeriesPrevResponse>

    fun getStories() : Flow<StoriesPrevResponse>

    fun getEvents() : Flow<EventsPrevResponse>

    interface LocalComicsDataSource : ComicsDataSource
    interface RemoteComicsDataSource : ComicsDataSource

    // add another data source type is easy
    // ...

}
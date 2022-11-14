package com.chrrissoft.marvel.data.series

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import kotlinx.coroutines.flow.Flow

interface SeriesDataSource {

    fun getPreview() : Flow<SeriesPrevResponse>

    fun getCharacters() : Flow<CharsPrevResponse>

    fun getStories() : Flow<StoriesPrevResponse>

    fun getComics() : Flow<ComicsPrevResponse>

    fun getEvents() : Flow<EventsPrevResponse>

    interface LocalSeriesDataSource : SeriesDataSource
    interface RemoteSeriesDataSource : SeriesDataSource

    // add another data source type is easy
    // ...

}
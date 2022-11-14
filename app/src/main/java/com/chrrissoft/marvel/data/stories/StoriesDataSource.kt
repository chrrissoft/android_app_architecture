package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.data.characters.CharsPrevResponse
import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import kotlinx.coroutines.flow.Flow

interface StoriesDataSource {

    fun getPreview() : Flow<StoriesPrevResponse>

    fun getCharacters() : Flow<CharsPrevResponse>

    fun getSeries() : Flow<SeriesPrevResponse>

    fun getComics() : Flow<ComicsPrevResponse>

    fun getEvents() : Flow<EventsPrevResponse>

    interface LocalStoriesDataSource : StoriesDataSource
    interface RemoteStoriesDataSource : StoriesDataSource

    // add another data source type is easy
    // ...

}
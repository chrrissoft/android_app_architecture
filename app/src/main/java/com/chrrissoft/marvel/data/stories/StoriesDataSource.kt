package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow

interface StoriesDataSource {

    fun getPreview() : Flow<StoriesPrevRes>

    fun getCharacters() : Flow<CharsPrevRes>

    fun getSeries() : Flow<SeriesPrevRes>

    fun getComics() : Flow<ComicsPrevRes>

    fun getEvents() : Flow<EventsPrevRes>

    interface LocalStoriesDataSource : StoriesDataSource
    interface RemoteStoriesDataSource : StoriesDataSource

    // add another data source type is easy
    // ...

}
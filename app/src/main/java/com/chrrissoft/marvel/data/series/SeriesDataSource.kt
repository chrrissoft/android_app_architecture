package com.chrrissoft.marvel.data.series

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow

interface SeriesDataSource {

    fun getPreview() : Flow<SeriesPrevRes>

    fun getCharacters() : Flow<CharsPrevRes>

    fun getStories() : Flow<StoriesPrevRes>

    fun getComics() : Flow<ComicsPrevRes>

    fun getEvents() : Flow<EventsPrevRes>

    interface LocalSeriesDataSource : SeriesDataSource
    interface RemoteSeriesDataSource : SeriesDataSource

    // add another data source type is easy
    // ...

}
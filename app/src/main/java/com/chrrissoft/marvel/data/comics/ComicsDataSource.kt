package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow

interface ComicsDataSource {

    fun getPreview() : Flow<ComicsPrevRes>

    fun getCharacters() : Flow<CharsPrevRes>

    fun getSeries() : Flow<SeriesPrevRes>

    fun getStories() : Flow<StoriesPrevRes>

    fun getEvents() : Flow<EventsPrevRes>

    interface LocalComicsDataSource : ComicsDataSource
    interface RemoteComicsDataSource : ComicsDataSource

    // add another data source type is easy
    // ...

}
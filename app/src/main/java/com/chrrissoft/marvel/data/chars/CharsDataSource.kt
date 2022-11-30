package com.chrrissoft.marvel.data.chars

import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.framework.chars.datasource.*
import kotlinx.coroutines.flow.Flow

interface CharsDataSource {

    fun getChars(offset: CharsOffset) : Flow<List<CharsPreview>>

    fun getComics(id: Int, offset: ComicsOffset) : Flow<List<ComicPreview>>

    fun getSeries(id: Int, offset: SeriesOffset) : Flow<List<SeriesPreview>>

    fun getStories(id: Int, offset: StoriesOffset) : Flow<List<StoriesPreview>>

    fun getEvents(id: Int, offset: EventsOffset) : Flow<List<EventPreview>>

    interface RemoteCharsDataSource : CharsDataSource
    interface LocalCharsDataSource : CharsDataSource

}

package com.chrrissoft.marvel.data.chars

import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.framework.chars.datasource.*
import com.chrrissoft.marvel.framework.comics.datasource.ComicsOffset
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.series.datasource.SeriesOffset
import com.chrrissoft.marvel.framework.stories.datasource.StoriesOffset
import kotlinx.coroutines.flow.Flow

interface CharsDataSource {

    fun getChar(id: Int) : Flow<CharsPreview>

    fun getChars(offset: CharsOffset) : Flow<List<CharsPreview>>

    fun getComics(id: Int, offset: ComicsOffset) : Flow<List<ComicPreview>>

    fun getSeries(id: Int, offset: SeriesOffset) : Flow<List<SeriesPreview>>

    fun getStories(id: Int, offset: StoriesOffset) : Flow<List<StoriesPreview>>

    fun getEvents(id: Int, offset: EventsOffset) : Flow<List<EventPreview>>

    interface LocalCharsDataSource : CharsDataSource
    interface RemoteCharsDataSource : CharsDataSource

}

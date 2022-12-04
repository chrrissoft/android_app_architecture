package com.chrrissoft.marvel.data.series

import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.framework.chars.datasource.CharsOffset
import com.chrrissoft.marvel.framework.comics.datasource.ComicsOffset
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.series.datasource.SeriesOffset
import com.chrrissoft.marvel.framework.stories.datasource.StoriesOffset
import kotlinx.coroutines.flow.Flow

interface SeriesDataSource {

    fun getSerie(id: Int) : Flow<SeriesPreview>

    fun getChars(id: Int, offset: CharsOffset) : Flow<List<CharsPreview>>

    fun getComics(id: Int, offset: ComicsOffset) : Flow<List<ComicPreview>>

    fun getSeries(offset: SeriesOffset) : Flow<List<SeriesPreview>>

    fun getStories(id: Int, offset: StoriesOffset) : Flow<List<StoriesPreview>>

    fun getEvents(id: Int, offset: EventsOffset) : Flow<List<EventPreview>>

    interface LocalSeriesDataSource : SeriesDataSource
    interface RemoteSeriesDataSource : SeriesDataSource

}

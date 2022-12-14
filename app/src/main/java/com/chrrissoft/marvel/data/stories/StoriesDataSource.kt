package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.framework.chars.datasource.CharsOffset
import com.chrrissoft.marvel.framework.comics.datasource.ComicsOffset
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.series.datasource.SeriesOffset
import com.chrrissoft.marvel.framework.stories.datasource.StoriesOffset
import kotlinx.coroutines.flow.Flow

interface StoriesDataSource {

    fun getStory(id: Int) : Flow<StoriesPreview>

    fun getChars(id: Int, offset: CharsOffset) : Flow<List<CharsPreview>>

    fun getComics(id: Int, offset: ComicsOffset) : Flow<List<ComicPreview>>

    fun getSeries(id: Int, offset: SeriesOffset) : Flow<List<SeriesPreview>>

    fun getStories(offset: StoriesOffset) : Flow<List<StoriesPreview>>

    fun getEvents(id: Int, offset: EventsOffset) : Flow<List<EventPreview>>

    interface LocalStoriesDataSource : StoriesDataSource
    interface RemoteStoriesDataSource : StoriesDataSource

}

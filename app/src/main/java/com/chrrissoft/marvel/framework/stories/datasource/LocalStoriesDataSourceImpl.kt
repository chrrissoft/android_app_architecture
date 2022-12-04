package com.chrrissoft.marvel.framework.stories.datasource

import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.stories.StoriesDataSource.LocalStoriesDataSource
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.framework.chars.datasource.CharsOffset
import com.chrrissoft.marvel.framework.comics.datasource.ComicsOffset
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.series.datasource.SeriesOffset
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalStoriesDataSourceImpl @Inject constructor() : LocalStoriesDataSource {

    override fun getStory(id: Int): Flow<StoriesPreview> {
        TODO("Implement support to local access")
    }

    override fun getChars(id: Int, offset: CharsOffset): Flow<List<CharsPreview>> {
        TODO("Implement support to local access")
    }

    override fun getComics(id: Int, offset: ComicsOffset): Flow<List<ComicPreview>> {
        TODO("Implement support to local access")
    }

    override fun getSeries(id: Int, offset: SeriesOffset): Flow<List<SeriesPreview>> {
        TODO("Implement support to local access")
    }

    override fun getStories(offset: StoriesOffset): Flow<List<StoriesPreview>> {
        TODO("Implement support to local access")
    }

    override fun getEvents(id: Int, offset: EventsOffset): Flow<List<EventPreview>> {
        TODO("Implement support to local access")
    }
}

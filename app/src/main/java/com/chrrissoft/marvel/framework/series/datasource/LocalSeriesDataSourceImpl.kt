package com.chrrissoft.marvel.framework.series.datasource

import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.series.SeriesDataSource.LocalSeriesDataSource
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.framework.chars.datasource.CharsOffset
import com.chrrissoft.marvel.framework.comics.datasource.ComicsOffset
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.stories.datasource.StoriesOffset
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalSeriesDataSourceImpl @Inject constructor() : LocalSeriesDataSource {

    override fun getSerie(id: Int): Flow<SeriesPreview> {
        TODO("Implement support to local access")
    }

    override fun getChars(id: Int, offset: CharsOffset): Flow<List<CharsPreview>> {
        TODO("Implement support to local access")
    }

    override fun getComics(id: Int, offset: ComicsOffset): Flow<List<ComicPreview>> {
        TODO("Implement support to local access")
    }

    override fun getSeries(offset: SeriesOffset): Flow<List<SeriesPreview>> {
        TODO("Implement support to local access")
    }

    override fun getStories(id: Int, offset: StoriesOffset): Flow<List<StoriesPreview>> {
        TODO("Implement support to local access")
    }

    override fun getEvents(id: Int, offset: EventsOffset): Flow<List<EventPreview>> {
        TODO("Implement support to local access")
    }
}

package com.chrrissoft.marvel.framework.comics.datasource

import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.comics.ComicsDataSource.LocalComicsDataSource
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.framework.chars.datasource.CharsOffset
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.series.datasource.SeriesOffset
import com.chrrissoft.marvel.framework.stories.datasource.StoriesOffset
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class LocalComicsDataSourceImpl @Inject constructor() : LocalComicsDataSource {
    override fun getChars(id: Int, offset: CharsOffset): Flow<List<CharsPreview>> {
        return emptyFlow()
    }

    override fun getComics(offset: ComicsOffset): Flow<List<ComicPreview>> {
        return emptyFlow()
    }

    override fun getSeries(id: Int, offset: SeriesOffset): Flow<List<SeriesPreview>> {
        return emptyFlow()
    }

    override fun getStories(id: Int, offset: StoriesOffset): Flow<List<StoriesPreview>> {
        return emptyFlow()
    }

    override fun getEvents(id: Int, offset: EventsOffset): Flow<List<EventPreview>> {
        return emptyFlow()
    }

}

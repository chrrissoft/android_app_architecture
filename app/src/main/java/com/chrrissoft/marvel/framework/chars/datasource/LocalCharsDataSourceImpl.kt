package com.chrrissoft.marvel.framework.chars.datasource

import com.chrrissoft.marvel.data.chars.CharsDataSource.LocalCharsDataSource
import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.framework.chars.db.CharacterDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class LocalCharsDataSourceImpl @Inject constructor(
    private val dao: CharacterDao
) : LocalCharsDataSource {

    override fun getChars(offset: CharsOffset): Flow<List<CharsPreview>> {
        return emptyFlow()
    }

    override fun getComics(id: Int, offset: ComicsOffset): Flow<List<ComicPreview>> {
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
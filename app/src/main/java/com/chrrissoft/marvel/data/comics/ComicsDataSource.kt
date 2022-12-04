package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.framework.chars.datasource.CharsOffset
import com.chrrissoft.marvel.framework.comics.datasource.ComicsOffset
import com.chrrissoft.marvel.framework.events.datasource.EventsOffset
import com.chrrissoft.marvel.framework.series.datasource.SeriesOffset
import com.chrrissoft.marvel.framework.stories.datasource.StoriesOffset
import kotlinx.coroutines.flow.Flow

interface ComicsDataSource {

    fun getComic(id: Int) : Flow<ComicPreview>

    fun getChars(id: Int, offset: CharsOffset) : Flow<List<CharsPreview>>

    fun getComics(offset: ComicsOffset) : Flow<List<ComicPreview>>

    fun getSeries(id: Int, offset: SeriesOffset) : Flow<List<SeriesPreview>>

    fun getStories(id: Int, offset: StoriesOffset) : Flow<List<StoriesPreview>>

    fun getEvents(id: Int, offset: EventsOffset) : Flow<List<EventPreview>>

    interface LocalComicsDataSource : ComicsDataSource
    interface RemoteComicsDataSource : ComicsDataSource

}

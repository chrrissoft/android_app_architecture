package com.chrrissoft.marvel.data.events

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow


abstract class EventsRepo {

    enum class Source { REMOTE, LOCAL }
    enum class RequestOf { CHARS, COMICS, SERIES, STORIES, EVENT }

    abstract fun getPreviews(source: Source): Flow<EventsPrevRes>
    abstract fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Event>

    protected abstract fun getSelf(id: Int, source: Source): Flow<EventRes>

    protected abstract fun getChars(id: Int, source: Source): Flow<CharsPrevRes>

    protected abstract fun getComics(id: Int, source: Source): Flow<ComicsPrevRes>

    protected abstract fun getSeries(id: Int, source: Source): Flow<SeriesPrevRes>

    protected abstract fun getStories(id: Int, source: Source): Flow<StoriesPrevRes>

}

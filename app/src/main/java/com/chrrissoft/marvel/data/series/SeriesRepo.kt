package com.chrrissoft.marvel.data.series

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SerieRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow


abstract class SeriesRepo {

    enum class Source { REMOTE, LOCAL }
    enum class RequestOf { CHARS, COMICS, STORIES, EVENTS }

    abstract fun getPreviews(source: Source): Flow<SeriesPrevRes>
    abstract fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Serie>

    protected abstract fun getSelfFromCache(id: Int): Flow<SerieRes>

    protected abstract fun getChars(id: Int, source: Source): Flow<CharsPrevRes>

    protected abstract fun getComics(id: Int, source: Source): Flow<ComicsPrevRes>

    protected abstract fun getStories(id: Int, source: Source): Flow<StoriesPrevRes>

    protected abstract fun getEvents(id: Int, source: Source): Flow<EventsPrevRes>

}

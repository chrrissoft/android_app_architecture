package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow


abstract class ComicsRepo {

    enum class Source { REMOTE, LOCAL }
    enum class RequestOf { CHARS, SERIES, STORIES, EVENTS }

    abstract fun getPreviews(source: Source): Flow<ComicsPrevRes>
    abstract fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Comic>

    protected abstract fun getSelfFromCache(id: Int): Flow<ComicRes>

    protected abstract fun getChars(id: Int, source: Source): Flow<CharsPrevRes>

    protected abstract fun getSeries(id: Int, source: Source): Flow<SeriesPrevRes>

    protected abstract fun getStories(id: Int, source: Source): Flow<StoriesPrevRes>

    protected abstract fun getEvents(id: Int, source: Source): Flow<EventsPrevRes>

}

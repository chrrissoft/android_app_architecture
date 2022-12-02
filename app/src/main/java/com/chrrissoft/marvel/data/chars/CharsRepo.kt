package com.chrrissoft.marvel.data.chars

import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow


abstract class CharsRepo {

    enum class Source { REMOTE, LOCAL }
    enum class RequestOf { COMICS, SERIES, STORIES, EVENTS }

    abstract fun getPreviews(source: Source): Flow<CharsPrevRes>
    abstract fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Char>

    protected abstract fun getSelfFromCache(id: Int): Flow<CharRes>

    protected abstract fun getComics(id: Int, source: Source): Flow<ComicsPrevRes>

    protected abstract fun getSeries(id: Int, source: Source): Flow<SeriesPrevRes>

    protected abstract fun getStories(id: Int, source: Source): Flow<StoriesPrevRes>

    protected abstract fun getEvents(id: Int, source: Source): Flow<EventsPrevRes>

}

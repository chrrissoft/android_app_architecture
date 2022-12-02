package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoryRes
import kotlinx.coroutines.flow.Flow


abstract class StoriesRepo {

    enum class Source { REMOTE, LOCAL }
    enum class RequestOf { CHARS, COMICS, SERIES, EVENTS }

    abstract fun getPreviews(source: Source): Flow<StoriesPrevRes>
    abstract fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Story>

    protected abstract fun getSelfFromCache(id: Int): Flow<StoryRes>

    protected abstract fun getChars(id: Int, source: Source): Flow<CharsPrevRes>

    protected abstract fun getComics(id: Int, source: Source): Flow<ComicsPrevRes>

    protected abstract fun getSeries(id: Int, source: Source): Flow<SeriesPrevRes>

    protected abstract fun getEvents(id: Int, source: Source): Flow<EventsPrevRes>

}

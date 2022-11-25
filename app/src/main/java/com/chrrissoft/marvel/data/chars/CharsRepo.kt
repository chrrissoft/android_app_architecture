package com.chrrissoft.marvel.data.chars

import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow

interface CharsRepo {

    enum class Source { REMOTE, LOCAL }

    fun getChars(source: Source): Flow<CharsPrevRes>

//    fun getChar(id: Int, source: Source): Flow<CharRes>

    fun getComics(id: Int, source: Source): Flow<ComicsPrevRes>

    fun getEvents(id: Int, source: Source): Flow<EventsPrevRes>

    fun getStories(id: Int, source: Source): Flow<StoriesPrevRes>

    fun getSeries(id: Int, source: Source): Flow<SeriesPrevRes>
}
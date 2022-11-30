package com.chrrissoft.marvel.data.series

import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import kotlinx.coroutines.flow.Flow


interface SeriesRepo {

    enum class Source { REMOTE, LOCAL }
    enum class RequestOf { CHARS, COMICS, STORIES, EVENTS }

    fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Serie>
    fun getPreviews(source: Source): Flow<SeriesPrevRes>

}
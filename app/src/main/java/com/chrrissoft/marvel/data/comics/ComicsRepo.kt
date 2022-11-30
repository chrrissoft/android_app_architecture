package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import kotlinx.coroutines.flow.Flow


interface ComicsRepo {

    enum class Source { REMOTE, LOCAL }
    enum class RequestOf { CHARS, SERIES, STORIES, EVENTS }

    fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Comic>
    fun getPreviews(source: Source): Flow<ComicsPrevRes>

}
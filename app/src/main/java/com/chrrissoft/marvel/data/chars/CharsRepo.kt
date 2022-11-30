package com.chrrissoft.marvel.data.chars

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import kotlinx.coroutines.flow.Flow


interface CharsRepo {

    enum class Source { REMOTE, LOCAL }
    enum class RequestOf { COMICS, SERIES, STORIES, EVENTS }

    fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Char>
    fun getPreviews(source: Source): Flow<CharsPrevRes>

}
package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow


interface StoriesRepo {

    enum class Source { REMOTE, LOCAL }
    enum class RequestOf { CHARS, COMICS, SERIES, EVENTS }

    fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Story>
    fun getPreviews(source: Source): Flow<StoriesPrevRes>

}
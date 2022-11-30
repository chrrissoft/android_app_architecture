package com.chrrissoft.marvel.data.events

import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import kotlinx.coroutines.flow.Flow


interface EventsRepo {

    enum class Source { REMOTE, LOCAL }
    enum class RequestOf { CHARS, COMICS, SERIES, STORIES }

    fun getInfo(id: Int, requestOf: RequestOf, source: Source): Flow<Event>
    fun getPreviews(source: Source): Flow<EventsPrevRes>

}
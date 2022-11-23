package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SerieRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoryRes
import kotlinx.coroutines.flow.Flow


interface ComicsRepo {

    enum class Source { REMOTE, LOCAL }

    fun get(source: Source): Flow<ComicRes>
    fun getPreviews(source: Source): Flow<ComicsPrevRes>

    fun getChars(source: Source): Flow<CharsPrevRes>
    fun geChar(source: Source): Flow<CharRes>

    fun getEvents(source: Source): Flow<EventsPrevRes>
    fun getEvent(source: Source): Flow<EventRes>

    fun getStories(source: Source): Flow<StoriesPrevRes>
    fun getStory(source: Source): Flow<StoryRes>

    fun getSeries(source: Source): Flow<SeriesPrevRes>
    fun getSerie(source: Source): Flow<SerieRes>

}
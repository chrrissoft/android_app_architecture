package com.chrrissoft.marvel.data.stories

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


interface StoriesRepo {

    enum class Source { REMOTE, LOCAL }

    fun get(source: Source): Flow<StoryRes>
    fun getPreviews(source: Source): Flow<StoriesPrevRes>

    fun getChars(source: Source): Flow<CharsPrevRes>
    fun geChar(source: Source): Flow<CharRes>

    fun getComics(source: Source): Flow<ComicsPrevRes>
    fun getComic(source: Source): Flow<ComicRes>

    fun getStories(source: Source): Flow<SeriesPrevRes>
    fun getStory(source: Source): Flow<SerieRes>

    fun getEvents(source: Source): Flow<EventsPrevRes>
    fun getEvent(source: Source): Flow<EventRes>

}
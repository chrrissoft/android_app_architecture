package com.chrrissoft.marvel.data.chars

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow

interface CharacterDataSource {

    fun get(id: Int) : Flow<CharsPreview>

    fun getPreviews() : Flow<CharsPrevRes>

    fun getComics(id: Int) : Flow<ComicsPrevRes>

    fun getSeries(id: Int) : Flow<SeriesPrevRes>

    fun getStories(id: Int) : Flow<StoriesPrevRes>

    fun getEvents(id: Int) : Flow<EventsPrevRes>

    interface RemoteCharacterDataSource : CharacterDataSource
    interface LocalCharacterDataSource : CharacterDataSource

}
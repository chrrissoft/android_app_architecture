package com.chrrissoft.marvel.data.chars

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import kotlinx.coroutines.flow.Flow

interface CharacterDataSource {

    fun getPreviews() : Flow<CharsPrevRes>

    fun getComics() : Flow<ComicsPrevRes>

    fun getSeries() : Flow<SeriesPrevRes>

    fun getStories() : Flow<StoriesPrevRes>

    fun getEvents() : Flow<EventsPrevRes>

    interface RemoteCharacterDataSource : CharacterDataSource
    interface LocalCharacterDataSource : CharacterDataSource

}
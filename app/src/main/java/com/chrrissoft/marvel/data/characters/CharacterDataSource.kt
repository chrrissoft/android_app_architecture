package com.chrrissoft.marvel.data.characters

import com.chrrissoft.marvel.data.comics.ComicsPrevResponse
import com.chrrissoft.marvel.data.events.EventsPrevResponse
import com.chrrissoft.marvel.data.series.SeriesPrevResponse
import com.chrrissoft.marvel.data.stories.StoriesPrevResponse
import kotlinx.coroutines.flow.Flow

interface CharacterDataSource {

    fun getPreviews() : Flow<CharsPrevResponse>

    fun getComics() : Flow<ComicsPrevResponse>

    fun getSeries() : Flow<SeriesPrevResponse>

    fun getStories() : Flow<StoriesPrevResponse>

    fun getEvents() : Flow<EventsPrevResponse>

    interface LocalCharacterDataSource : CharacterDataSource
    interface RemoteCharacterDataSource : CharacterDataSource

    // add another data source type is easy

}
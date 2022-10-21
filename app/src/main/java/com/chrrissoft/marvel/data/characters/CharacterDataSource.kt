package com.chrrissoft.marvel.data.characters

import com.chrrissoft.marvel.data.characters.response.CharacterInfoResponse
import com.chrrissoft.marvel.data.characters.response.CharacterPreviewResponse
import kotlinx.coroutines.flow.Flow

interface CharacterDataSource {

    interface LocalCharacterDataSource : CharacterDataSource
    interface RemoteCharacterDataSource : CharacterDataSource

    fun getById(id: Int) : Flow<CharacterInfoResponse>

    fun getAll() : Flow<CharacterPreviewResponse>

    // add another data source type is easy
    // ...

}
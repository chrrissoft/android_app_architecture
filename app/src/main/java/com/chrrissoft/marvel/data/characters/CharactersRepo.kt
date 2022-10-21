package com.chrrissoft.marvel.data.characters

import com.chrrissoft.marvel.data.characters.response.CharacterInfoResponse
import com.chrrissoft.marvel.data.characters.response.CharacterPreviewResponse
import kotlinx.coroutines.flow.Flow

interface CharactersRepo {

    fun getByIdFromLocale(id: Int) : Flow<CharacterInfoResponse>
    fun getAllFromLocale() : Flow<CharacterPreviewResponse>

    fun getByIdFromRemote(id: Int) : Flow<CharacterInfoResponse>
    fun getAllFromRemote() : Flow<CharacterPreviewResponse>

}
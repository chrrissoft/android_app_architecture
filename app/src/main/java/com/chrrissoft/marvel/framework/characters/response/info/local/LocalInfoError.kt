package com.chrrissoft.marvel.framework.characters.response.info.local

import com.chrrissoft.marvel.data.characters.response.CharacterInfoResponse
import com.chrrissoft.marvel.ui.characters.state.info.CharacterInfo

object LocalInfoError : CharacterInfoResponse.LocalCharacterInfoResponse {
    override fun toUI(): CharacterInfo = CharacterInfo()
}
package com.chrrissoft.marvel.framework.characters.response.info.remote

import com.chrrissoft.marvel.data.characters.response.CharacterInfoResponse
import com.chrrissoft.marvel.ui.characters.state.info.CharacterInfo

object ApiInfoError : CharacterInfoResponse.RemoteCharacterInfoResponse {
    override fun toUI(): CharacterInfo = CharacterInfo()
}
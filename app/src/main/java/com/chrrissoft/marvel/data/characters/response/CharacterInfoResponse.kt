package com.chrrissoft.marvel.data.characters.response

import com.chrrissoft.marvel.ui.characters.state.info.CharacterInfo as UiCharacterInfo

interface CharacterInfoResponse {

    interface LocalCharacterInfoResponse : CharacterInfoResponse
    interface RemoteCharacterInfoResponse : CharacterInfoResponse

    fun toUI() : UiCharacterInfo
}

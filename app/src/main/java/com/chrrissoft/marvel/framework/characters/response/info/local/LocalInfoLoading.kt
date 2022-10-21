package com.chrrissoft.marvel.framework.characters.response.info.local

import com.chrrissoft.marvel.data.characters.response.CharacterInfoResponse.LocalCharacterInfoResponse
import com.chrrissoft.marvel.ui.characters.state.info.CharacterInfo as UiCharacterInfo


object LocalInfoLoading : LocalCharacterInfoResponse {
    override fun toUI(): UiCharacterInfo = UiCharacterInfo()
}

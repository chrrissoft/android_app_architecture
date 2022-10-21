package com.chrrissoft.marvel.framework.characters.response.info.remote

import com.chrrissoft.marvel.data.characters.response.CharacterInfoResponse.RemoteCharacterInfoResponse
import com.chrrissoft.marvel.ui.characters.state.info.CharacterInfo as UiCharacterInfo


object ApiInfoLoading : RemoteCharacterInfoResponse {
    override fun toUI(): UiCharacterInfo = UiCharacterInfo()
}


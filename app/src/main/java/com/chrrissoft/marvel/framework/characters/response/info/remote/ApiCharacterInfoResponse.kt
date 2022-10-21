package com.chrrissoft.marvel.framework.characters.response.info.remote

import com.chrrissoft.marvel.data.characters.response.CharacterInfoResponse.RemoteCharacterInfoResponse
import com.chrrissoft.marvel.ui.characters.state.info.CharacterInfo as UiCharacterInfo
import com.chrrissoft.marvel.framework.characters.models.info.CharacterInfo as ApiCharacterInfo

data class ApiCharacterInfoResponse(
    val info: ApiCharacterInfo
) : RemoteCharacterInfoResponse {
    override fun toUI(): UiCharacterInfo = info.toUi()
}
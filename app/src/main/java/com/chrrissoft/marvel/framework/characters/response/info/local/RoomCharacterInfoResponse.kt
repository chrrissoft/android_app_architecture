package com.chrrissoft.marvel.framework.characters.response.info.local

import com.chrrissoft.marvel.data.characters.response.CharacterInfoResponse.LocalCharacterInfoResponse
import com.chrrissoft.marvel.framework.characters.database.info.CharacterInfo
import com.chrrissoft.marvel.ui.characters.state.info.CharacterInfo as UiCharacterInfo

data class RoomCharacterInfoResponse(
    val info: CharacterInfo,
) : LocalCharacterInfoResponse {
    override fun toUI(): UiCharacterInfo = info.toUi()
}
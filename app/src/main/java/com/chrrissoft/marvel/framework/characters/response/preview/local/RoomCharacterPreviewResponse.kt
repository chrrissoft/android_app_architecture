package com.chrrissoft.marvel.framework.characters.response.preview.local

import com.chrrissoft.marvel.data.characters.response.CharacterPreviewResponse.LocalCharacterPreviewResponse
import com.chrrissoft.marvel.framework.characters.database.preview.CharacterPreview
import com.chrrissoft.marvel.ui.characters.state.preview.CharacterPreview as UiCharacterPreview

data class RoomCharacterPreviewResponse(
    val prev: List<CharacterPreview>,
) : LocalCharacterPreviewResponse {
    override fun toUI(): List<UiCharacterPreview> {
        return prev.map { it.toUi() }
    }
}
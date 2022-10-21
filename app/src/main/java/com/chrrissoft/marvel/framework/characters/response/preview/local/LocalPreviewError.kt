package com.chrrissoft.marvel.framework.characters.response.preview.local

import com.chrrissoft.marvel.data.characters.response.CharacterPreviewResponse
import com.chrrissoft.marvel.ui.characters.state.preview.CharacterPreview

object LocalPreviewError : CharacterPreviewResponse.LocalCharacterPreviewResponse {
    override fun toUI(): List<CharacterPreview> = emptyList()
}
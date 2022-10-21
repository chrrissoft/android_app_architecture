package com.chrrissoft.marvel.framework.characters.response.preview.local

import com.chrrissoft.marvel.data.characters.response.CharacterPreviewResponse.LocalCharacterPreviewResponse
import com.chrrissoft.marvel.ui.characters.state.preview.CharacterPreview as UiCharacterPreview

object LocalPreviewLoading : LocalCharacterPreviewResponse {
    override fun toUI(): List<UiCharacterPreview> = emptyList()
}


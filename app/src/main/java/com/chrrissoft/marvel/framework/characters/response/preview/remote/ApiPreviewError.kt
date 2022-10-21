package com.chrrissoft.marvel.framework.characters.response.preview.remote

import com.chrrissoft.marvel.data.characters.response.CharacterPreviewResponse
import com.chrrissoft.marvel.ui.characters.state.preview.CharacterPreview

object ApiPreviewError : CharacterPreviewResponse.RemoteCharacterPreviewResponse {
    override fun toUI(): List<CharacterPreview> = emptyList()
}
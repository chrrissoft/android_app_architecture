package com.chrrissoft.marvel.framework.characters.response.preview.remote

import com.chrrissoft.marvel.data.characters.response.CharacterPreviewResponse.RemoteCharacterPreviewResponse
import com.chrrissoft.marvel.ui.characters.state.preview.CharacterPreview

object ApiPreviewLoading : RemoteCharacterPreviewResponse {
    override fun toUI(): List<CharacterPreview> = emptyList()
}


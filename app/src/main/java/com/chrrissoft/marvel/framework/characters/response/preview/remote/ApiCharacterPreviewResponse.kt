package com.chrrissoft.marvel.framework.characters.response.preview.remote

import com.chrrissoft.marvel.data.characters.response.CharacterPreviewResponse.RemoteCharacterPreviewResponse
import com.chrrissoft.marvel.framework.characters.models.preview.CharactersPreview
import com.chrrissoft.marvel.ui.characters.state.preview.CharacterPreview

data class ApiCharacterPreviewResponse(
    val prev: List<CharactersPreview>
) : RemoteCharacterPreviewResponse {
    override fun toUI():
            List<CharacterPreview> = prev.map { it.toUi() }
}
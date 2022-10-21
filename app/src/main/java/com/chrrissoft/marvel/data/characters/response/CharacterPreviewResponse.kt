package com.chrrissoft.marvel.data.characters.response

import com.chrrissoft.marvel.ui.characters.state.preview.CharacterPreview


interface CharacterPreviewResponse {

    interface LocalCharacterPreviewResponse : CharacterPreviewResponse
    interface RemoteCharacterPreviewResponse : CharacterPreviewResponse

    fun toUI(): List<CharacterPreview>
}
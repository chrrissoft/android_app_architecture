package com.chrrissoft.marvel.data.characters.models

import com.chrrissoft.marvel.ui.characters.state.preview.CharacterPreview

interface CharactersPreview {
    val id: Int
    val name: String
    val thumbnail: Any

    fun toUi() =
        CharacterPreview(
            id = id,
            name = name,
            thumbnail = thumbnail,
        )
}
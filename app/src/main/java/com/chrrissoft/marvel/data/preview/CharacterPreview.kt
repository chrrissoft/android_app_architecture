package com.chrrissoft.marvel.data.preview

import com.chrrissoft.marvel.ui.preview.CharacterPreview

interface CharacterPreview {
    val id: Int
    val name: String
    val image: Any

    fun toUi() = CharacterPreview(id, name, image)
}
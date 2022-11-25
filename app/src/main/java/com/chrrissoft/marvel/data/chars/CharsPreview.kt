package com.chrrissoft.marvel.data.chars

import com.chrrissoft.marvel.ui.chars.CharsPreview

interface CharsPreview {
    val id: Int
    val name: String
    val image: Any?

    fun toUi() = CharsPreview(id, name, convertImage())

    fun convertImage() : Any?
}
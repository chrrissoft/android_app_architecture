package com.chrrissoft.marvel.data.preview

import com.chrrissoft.marvel.ui.preview.ComicPreview

interface ComicPreview {
    val id: Int
    val title: String
    val image: Any

    fun toUi() = ComicPreview(id, title, image)
}
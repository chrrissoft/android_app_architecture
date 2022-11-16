package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.ui.data.comics.ComicPreview

interface ComicPreview {
    val id: Int
    val title: String
    val image: Any

    fun toUi() = ComicPreview(id, title, image)
}
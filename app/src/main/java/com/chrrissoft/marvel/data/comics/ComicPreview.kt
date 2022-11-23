package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.ui.comics.ComicsPreview

interface ComicPreview {
    val id: Int
    val title: String
    val image: Any

    fun toUi() = ComicsPreview(id, title, image)
}
package com.chrrissoft.marvel.data.preview

import com.chrrissoft.marvel.ui.preview.StoriesPreview

interface StoriesPreview {
    val id: Int
    val title: String
    val image: Any

    fun toUi() = StoriesPreview(id, title, image)
}

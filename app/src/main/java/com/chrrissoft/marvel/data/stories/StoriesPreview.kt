package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.ui.data.stories.StoriesPreview

interface StoriesPreview {
    val id: Int
    val title: String
    val image: Any

    fun toUi() = StoriesPreview(id, title, image)
}

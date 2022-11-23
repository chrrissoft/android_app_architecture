package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.ui.stories.StoryPreview

interface StoriesPreview {
    val id: Int
    val title: String
    val image: Any

    fun toUi() = StoryPreview(id, title, image)
}

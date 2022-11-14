package com.chrrissoft.marvel.data.preview

import com.chrrissoft.marvel.ui.preview.EventPreview

interface EventPreview {
    val id: Int
    val title: String
    val image: Any

    fun toUi() = EventPreview(id, title, image)
}

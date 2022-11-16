package com.chrrissoft.marvel.data.events

import com.chrrissoft.marvel.ui.data.events.EventPreview

interface EventPreview {
    val id: Int
    val title: String
    val image: Any

    fun toUi() = EventPreview(id, title, image)
}

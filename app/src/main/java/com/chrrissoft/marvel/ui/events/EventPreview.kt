package com.chrrissoft.marvel.ui.events

data class EventPreview(
    val id: Int,
    val title: String,
    val image: Any,
    val charsCount: Int = 0,
    val seriesCount: Int = 0,
    val storiesCount: Int = 0,
    val comicsCount: Int = 0,
)

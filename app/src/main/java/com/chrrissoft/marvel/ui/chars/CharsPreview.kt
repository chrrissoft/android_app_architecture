package com.chrrissoft.marvel.ui.chars

data class CharsPreview(
    val id: Int,
    val name: String,
    val image: Any?,
    val comicsCount: Int = 100,
    val seriesCount: Int = 100,
    val storiesCount: Int = 100,
    val eventsCount: Int = 100,
)

package com.chrrissoft.marvel.ui.series

data class SeriesPreview(
    val id: Int,
    val title: String,
    val image: Any,
    val charsCount: Int = 0,
    val seriesCount: Int = 0,
    val eventsCount: Int = 0,
    val comicsCount: Int = 0,
)

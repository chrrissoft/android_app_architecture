package com.chrrissoft.marvel.ui.data

import com.chrrissoft.marvel.ui.preview.*


data class Character(
    val name: String,
    val image: Any,
    val comics: List<ComicPreview>,
    val events: List<EventPreview>,
    val stories: List<StoriesPreview>,
    val series: List<SeriesPreview>
)
package com.chrrissoft.marvel.ui.data

import com.chrrissoft.marvel.ui.preview.*


data class Stories(
    val title: String,
    val image: Any,
    val characters: List<CharacterPreview>,
    val events: List<EventPreview>,
    val comics: List<ComicPreview>,
    val series: List<SeriesPreview>
)
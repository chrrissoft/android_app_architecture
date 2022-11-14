package com.chrrissoft.marvel.ui.data

import com.chrrissoft.marvel.ui.preview.*


data class Event(
    val title: String,
    val image: Any,
    val characters: List<CharacterPreview>,
    val comics: List<ComicPreview>,
    val stories: List<StoriesPreview>,
    val series: List<SeriesPreview>
)
package com.chrrissoft.marvel.ui.data

import com.chrrissoft.marvel.ui.preview.*


data class Series(
    val title: String,
    val image: Any,
    val characters: List<CharacterPreview>,
    val events: List<EventPreview>,
    val stories: List<StoriesPreview>,
    val comics: List<ComicPreview>
    )

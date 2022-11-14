package com.chrrissoft.marvel.data.series

import com.chrrissoft.marvel.data.preview.*
import com.chrrissoft.marvel.ui.data.Series

interface Series {
    val title: String
    val image: Any
    val events: List<EventPreview>
    val comics: List<ComicPreview>
    val stories: List<StoriesPreview>
    val characters: List<CharacterPreview>

    fun toUi() = Series(
        title = title,
        image = image,
        events = events.map { it.toUi() },
        comics = comics.map { it.toUi() },
        stories = stories.map { it.toUi() },
        characters = characters.map { it.toUi() },
    )
}
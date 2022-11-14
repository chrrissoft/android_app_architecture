package com.chrrissoft.marvel.data.characters

import com.chrrissoft.marvel.data.preview.*
import com.chrrissoft.marvel.ui.data.Character


interface Character {
    val name: String
    val image: Any
    val comics: List<ComicPreview>
    val series: List<SeriesPreview>
    val events: List<EventPreview>
    val stories: List<StoriesPreview>

    fun toUi() = Character(
        name = name,
        image = image,
        events = events.map { it.toUi() },
        series = series.map { it.toUi() },
        comics = comics.map { it.toUi() },
        stories = stories.map { it.toUi() },
    )
}
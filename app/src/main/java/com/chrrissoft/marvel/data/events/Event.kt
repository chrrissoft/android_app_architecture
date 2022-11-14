package com.chrrissoft.marvel.data.events

import com.chrrissoft.marvel.data.preview.CharacterPreview
import com.chrrissoft.marvel.data.preview.ComicPreview
import com.chrrissoft.marvel.data.preview.SeriesPreview
import com.chrrissoft.marvel.data.preview.StoriesPreview
import com.chrrissoft.marvel.ui.data.Event


interface Event {
    val title: String
    val image: Any
    val comics: List<ComicPreview>
    val series: List<SeriesPreview>
    val stories: List<StoriesPreview>
    val characters: List<CharacterPreview>

    fun toUi() = Event(
        title = title,
        image = image,
        comics = comics.map { it.toUi() },
        series = series.map { it.toUi() },
        stories = stories.map { it.toUi() },
        characters = characters.map { it.toUi() },
    )
}
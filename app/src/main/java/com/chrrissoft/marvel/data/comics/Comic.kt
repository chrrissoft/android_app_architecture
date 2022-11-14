package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.preview.CharacterPreview
import com.chrrissoft.marvel.data.preview.EventPreview
import com.chrrissoft.marvel.data.preview.SeriesPreview
import com.chrrissoft.marvel.data.preview.StoriesPreview
import com.chrrissoft.marvel.ui.data.Comic

interface Comic {
    val title: String
    val image: Any
    val series: List<SeriesPreview>
    val events: List<EventPreview>
    val stories: List<StoriesPreview>
    val characters: List<CharacterPreview>

    fun toUi() = Comic(
        title = title,
        image = image,
        events = events.map { it.toUi() },
        series = series.map { it.toUi() },
        stories = stories.map { it.toUi() },
        characters = characters.map { it.toUi() },
    )
}
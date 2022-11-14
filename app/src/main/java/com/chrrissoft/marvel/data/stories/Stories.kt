package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.data.preview.CharacterPreview
import com.chrrissoft.marvel.data.preview.ComicPreview
import com.chrrissoft.marvel.data.preview.EventPreview
import com.chrrissoft.marvel.data.preview.SeriesPreview
import com.chrrissoft.marvel.ui.data.Stories

interface Stories {
    val title: String
    val image: Any
    val events: List<EventPreview>
    val comics: List<ComicPreview>
    val series: List<SeriesPreview>
    val characters: List<CharacterPreview>

    fun toUi() = Stories(
        title = title,
        image = image,
        characters = characters.map { it.toUi() },
        events = events.map {  it.toUi() },
        comics =comics.map {  it.toUi()},
        series =series.map {  it.toUi()}
    )
}
package com.chrrissoft.marvel.data.characters.models

import com.chrrissoft.marvel.data.comond.Comics
import com.chrrissoft.marvel.data.comond.Events
import com.chrrissoft.marvel.data.comond.Series
import com.chrrissoft.marvel.data.comond.Stories
import com.chrrissoft.marvel.ui.characters.state.info.CharacterInfo

interface CharacterInfo {
    val id: Int
    val name: String
    val description: String
    val thumbnail: Any
    val comics: Comics
    val series: Series
    val stories: Stories
    val events: Events

    fun toUi() =
        CharacterInfo(
            id = id,
            name = name,
            description = description,
            thumbnail = thumbnail,
            comics = comics.toUi(),
            series = series.toUI(),
            stories = stories.toUi(),
            events = events.toUi(),
        )
}
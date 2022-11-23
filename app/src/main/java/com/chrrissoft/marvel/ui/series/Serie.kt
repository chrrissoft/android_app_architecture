package com.chrrissoft.marvel.ui.series

import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes


data class Serie(
    val title: String,
    val image: Any,
    val characters: CharsPrevRes,
    val events: EventsPrevRes,
    val stories: StoriesPrevRes,
    val comics: ComicsPrevRes
) {
    companion object {
        val emptySerie = Serie(
            image = Any(),
            title = String(),
            comics = ComicsPrevRes(),
            events = EventsPrevRes(),
            stories = StoriesPrevRes(),
            characters = CharsPrevRes()
        )
    }

    fun isEmpty() = this === emptySerie
}
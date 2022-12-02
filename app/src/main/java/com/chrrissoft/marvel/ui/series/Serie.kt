package com.chrrissoft.marvel.ui.series

import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.series.res.SerieRes
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes


data class Serie(
    val self: SerieRes,
    val characters: CharsPrevRes,
    val events: EventsPrevRes,
    val stories: StoriesPrevRes,
    val comics: ComicsPrevRes
) {
    companion object {
        val emptySerie = Serie(
            self = SerieRes(),
            comics = ComicsPrevRes(),
            events = EventsPrevRes(),
            stories = StoriesPrevRes(),
            characters = CharsPrevRes()
        )
    }

    fun isEmpty() = this === emptySerie
}
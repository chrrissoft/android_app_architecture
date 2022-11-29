package com.chrrissoft.marvel.ui.events

import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.comics.Comic
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.events.res.EventRes
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.series.res.SeriesPrevRes
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes


data class Event(
    val self: EventRes,
    val characters: CharsPrevRes,
    val comics: ComicsPrevRes,
    val stories: StoriesPrevRes,
    val series: SeriesPrevRes
) {
    companion object {
        val emptyEvent = Event(
            self = EventRes(),
            comics = ComicsPrevRes(),
            series = SeriesPrevRes(),
            stories = StoriesPrevRes(),
            characters = CharsPrevRes()
        )
    }

    fun isEmpty() = this === emptyEvent
}
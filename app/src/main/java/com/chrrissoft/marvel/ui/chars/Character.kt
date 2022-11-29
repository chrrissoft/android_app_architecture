package com.chrrissoft.marvel.ui.chars

import com.chrrissoft.marvel.ui.chars.res.CharsRes
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.series.res.SeriesPrevRes
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes


data class Character(
    val self: CharsRes,
    val comics: ComicsPrevRes,
    val events: EventsPrevRes,
    val stories: StoriesPrevRes,
    val series: SeriesPrevRes,
) {
    companion object {
        val emptyChar = Character(
            self = CharsRes(),
            comics = ComicsPrevRes(),
            events = EventsPrevRes(),
            stories = StoriesPrevRes(),
            series = SeriesPrevRes(),
        )
    }

    fun isEmpty() = this == emptyChar
}
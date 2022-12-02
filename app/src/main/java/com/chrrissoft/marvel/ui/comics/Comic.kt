package com.chrrissoft.marvel.ui.comics

import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.comics.res.ComicRes
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.series.res.SeriesPrevRes
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes


data class Comic(
    val self: ComicRes,
    val characters: CharsPrevRes,
    val events: EventsPrevRes,
    val stories: StoriesPrevRes,
    val series: SeriesPrevRes
) {
    companion object {
        val emptyComic = Comic(
            self = ComicRes(),
            events = EventsPrevRes(),
            series = SeriesPrevRes(),
            stories = StoriesPrevRes(),
            characters = CharsPrevRes()
        )
    }

    fun isEmpty() = this === emptyComic
}
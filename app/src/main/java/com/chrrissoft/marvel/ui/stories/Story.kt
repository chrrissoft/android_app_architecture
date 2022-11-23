package com.chrrissoft.marvel.ui.stories

import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.series.Serie
import com.chrrissoft.marvel.ui.series.res.SeriesPrevRes
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes


data class Story(
    val title: String,
    val image: Any,
    val characters: CharsPrevRes,
    val events: EventsPrevRes,
    val comics: ComicsPrevRes,
    val series: SeriesPrevRes
) {
    companion object {
        val emptyStory = Story(
            image = Any(),
            title = String(),
            comics = ComicsPrevRes(),
            events = EventsPrevRes(),
            characters = CharsPrevRes(),
            series = SeriesPrevRes()
        )
    }

    fun isEmpty() = this === emptyStory
}
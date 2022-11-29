package com.chrrissoft.marvel.ui.stories

import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.series.Serie
import com.chrrissoft.marvel.ui.series.res.SeriesPrevRes
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.ui.stories.res.StoryRes


data class Story(
    val self: StoryRes,
    val characters: CharsPrevRes,
    val events: EventsPrevRes,
    val comics: ComicsPrevRes,
    val series: SeriesPrevRes
) {
    companion object {
        val emptyStory = Story(
            self = StoryRes(),
            comics = ComicsPrevRes(),
            events = EventsPrevRes(),
            characters = CharsPrevRes(),
            series = SeriesPrevRes()
        )
    }

    fun isEmpty() = this === emptyStory
}
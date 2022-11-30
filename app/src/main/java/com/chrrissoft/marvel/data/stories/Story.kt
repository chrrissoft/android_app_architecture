package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.chars.res.charsPrevConverter
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.comics.res.comicsPrevConverter
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.events.res.eventsPrevConverter
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.seriesPrevConverter
import com.chrrissoft.marvel.data.stories.res.StoryRes
import com.chrrissoft.marvel.data.stories.res.storyConverter
import com.chrrissoft.marvel.ui.stories.Story

interface Story {
    val self: StoryRes
    val events: EventsPrevRes
    val comics: ComicsPrevRes
    val series: SeriesPrevRes
    val characters: CharsPrevRes

    fun toUi() = Story(
        self = storyConverter(self),
        characters = charsPrevConverter(characters),
        events = eventsPrevConverter(events),
        comics = comicsPrevConverter(comics),
        series = seriesPrevConverter(series)
    )


}
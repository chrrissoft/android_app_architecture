package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.chars.res.charsPrevConverter
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.comics.res.comicConverter
import com.chrrissoft.marvel.data.events.res.eventsPrevConverter
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.seriesPrevConverter
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.storiesPrevConverter
import com.chrrissoft.marvel.ui.comics.Comic

interface Comic {
    val self: ComicRes
    val series: SeriesPrevRes
    val events: EventsPrevRes
    val stories: StoriesPrevRes
    val characters: CharsPrevRes

    fun toUi() = Comic(
        self = comicConverter(self),
        events = eventsPrevConverter(events),
        series = seriesPrevConverter(series),
        stories = storiesPrevConverter(stories),
        characters = charsPrevConverter(characters)
    )
}
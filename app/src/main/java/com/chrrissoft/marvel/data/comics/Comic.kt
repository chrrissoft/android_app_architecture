package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.chars.res.charsPrevConverter
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.events.res.eventsPrevConverter
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.seriesPrevConverter
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.storiesPrevConverter
import com.chrrissoft.marvel.ui.comics.Comic

interface Comic {
    val title: String
    val image: Any
    val series: SeriesPrevRes
    val events: EventsPrevRes
    val stories: StoriesPrevRes
    val characters: CharsPrevRes

    fun toUi() = Comic(
        title = title,
        image = image,
        events = eventsPrevConverter(events),
        series = seriesPrevConverter(series),
        stories = storiesPrevConverter(stories),
        characters = charsPrevConverter(characters)
    )
}
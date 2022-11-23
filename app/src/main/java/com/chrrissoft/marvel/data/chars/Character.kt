package com.chrrissoft.marvel.data.chars

import com.chrrissoft.marvel.data.comics.res.comicsPrevConverter
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.events.res.eventsPrevConverter
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.seriesPrevConverter
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.storiesPrevConverter
import com.chrrissoft.marvel.ui.chars.Character


interface Character {
    val name: String
    val image: Any
    val comics: ComicsPrevRes
    val series: SeriesPrevRes
    val events: EventsPrevRes
    val stories: StoriesPrevRes

    fun toUi() = Character(
        name = name,
        image = image,
        series = seriesPrevConverter(series),
        stories = storiesPrevConverter(stories),
        events = eventsPrevConverter(events),
        comics = comicsPrevConverter(comics),
    )

}


package com.chrrissoft.marvel.data.series

import com.chrrissoft.marvel.data.chars.res.charsPrevConverter
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.comicsPrevConverter
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.eventsPrevConverter
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.storiesPrevConverter
import com.chrrissoft.marvel.ui.series.Serie

interface Series {
    val title: String
    val image: Any
    val events: EventsPrevRes
    val comics: ComicsPrevRes
    val stories: StoriesPrevRes
    val characters: CharsPrevRes

    fun toUi() = Serie(
        title = title,
        image = image,
        events = eventsPrevConverter(events),
        comics = comicsPrevConverter(comics),
        stories = storiesPrevConverter(stories),
        characters = charsPrevConverter(characters),
    )
}
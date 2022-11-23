package com.chrrissoft.marvel.data.events

import com.chrrissoft.marvel.data.chars.res.charsPrevConverter
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.comicsPrevConverter
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.seriesPrevConverter
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.storiesPrevConverter
import com.chrrissoft.marvel.ui.events.Event


interface Event {
    val title: String
    val image: Any
    val comics: ComicsPrevRes
    val series: SeriesPrevRes
    val stories: StoriesPrevRes
    val characters: CharsPrevRes

    fun toUi() = Event(
        title = title,
        image = image,
        comics = comicsPrevConverter(comics),
        series = seriesPrevConverter(series),
        stories = storiesPrevConverter(stories),
        characters = charsPrevConverter(characters),
    )
}
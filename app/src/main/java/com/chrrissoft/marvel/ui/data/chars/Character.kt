package com.chrrissoft.marvel.ui.data.chars

import com.chrrissoft.marvel.ui.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.ui.data.stories.res.StoriesPrevRes


data class Character(
    val name: String,
    val image: Any,
    val comics: ComicsPrevRes,
    val events: EventsPrevRes,
    val stories: StoriesPrevRes,
    val series: SeriesPrevRes
)
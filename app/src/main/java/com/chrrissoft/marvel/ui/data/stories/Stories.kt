package com.chrrissoft.marvel.ui.data.stories

import com.chrrissoft.marvel.ui.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.data.series.res.SeriesPrevRes


data class Stories(
    val title: String,
    val image: Any,
    val characters: CharsPrevRes,
    val events: EventsPrevRes,
    val comics: ComicsPrevRes,
    val series: SeriesPrevRes
)
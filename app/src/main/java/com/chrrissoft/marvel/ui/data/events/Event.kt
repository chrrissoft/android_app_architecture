package com.chrrissoft.marvel.ui.data.events

import com.chrrissoft.marvel.ui.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.ui.data.stories.res.StoriesPrevRes


data class Event(
    val title: String,
    val image: Any,
    val characters: CharsPrevRes,
    val comics: ComicsPrevRes,
    val stories: StoriesPrevRes,
    val series: SeriesPrevRes
)
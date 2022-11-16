package com.chrrissoft.marvel.ui.data.comics

import com.chrrissoft.marvel.ui.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.ui.data.stories.res.StoriesPrevRes


data class Comic(
    val title: String,
    val image: Any,
    val characters: CharsPrevRes,
    val events: EventsPrevRes,
    val stories: StoriesPrevRes,
    val series: SeriesPrevRes
)

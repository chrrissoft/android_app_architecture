package com.chrrissoft.marvel.ui.data.series

import com.chrrissoft.marvel.ui.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.data.stories.res.StoriesPrevRes


data class Series(
    val title: String,
    val image: Any,
    val characters: CharsPrevRes,
    val events: EventsPrevRes,
    val stories: StoriesPrevRes,
    val comics: ComicsPrevRes
    )

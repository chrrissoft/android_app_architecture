package com.chrrissoft.marvel.framework.series

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevResState
import com.chrrissoft.marvel.data.series.Serie
import com.chrrissoft.marvel.data.series.res.SerieRes
import com.chrrissoft.marvel.data.series.res.SerieResState
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState

data class Serie(
    override val self: SerieRes = SerieRes(SerieResState.Loading()),
    override val events: EventsPrevRes = EventsPrevRes(EventsPrevResState.Loading()),
    override val comics: ComicsPrevRes = ComicsPrevRes(ComicsPrevResState.Loading()),
    override val stories: StoriesPrevRes = StoriesPrevRes(StoriesPrevResState.Loading()),
    override val chars: CharsPrevRes = CharsPrevRes(CharsPrevResState.Loading()),

    ) : Serie

package com.chrrissoft.marvel.framework.comics

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState
import com.chrrissoft.marvel.data.comics.Comic
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.comics.res.ComicResState
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevResState
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState

data class Comic(
    override val self: ComicRes = ComicRes(ComicResState.Loading()),
    override val series: SeriesPrevRes = SeriesPrevRes(SeriesPrevResState.Loading()),
    override val events: EventsPrevRes = EventsPrevRes(EventsPrevResState.Loading()),
    override val stories: StoriesPrevRes = StoriesPrevRes(StoriesPrevResState.Loading()),
    override val characters: CharsPrevRes = CharsPrevRes(CharsPrevResState.Loading()),

    ): Comic
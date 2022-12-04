package com.chrrissoft.marvel.framework.chars

import com.chrrissoft.marvel.data.chars.Char
import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.chars.res.CharResState
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevResState
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState

data class Char(
    override val self: CharRes = CharRes(CharResState.Loading()),
    override val comics: ComicsPrevRes = ComicsPrevRes(ComicsPrevResState.Loading()),
    override val series: SeriesPrevRes = SeriesPrevRes(SeriesPrevResState.Loading()),
    override val stories: StoriesPrevRes = StoriesPrevRes(StoriesPrevResState.Loading()),
    override val events: EventsPrevRes = EventsPrevRes(EventsPrevResState.Loading()),
) : Char {
    override fun clean() = Char()
}
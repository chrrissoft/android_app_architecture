package com.chrrissoft.marvel.framework.events

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState
import com.chrrissoft.marvel.data.events.Event
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.events.res.EventResState
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState

data class Event(
    override val self: EventRes = EventRes(EventResState.Loading()),
    override val comics: ComicsPrevRes = ComicsPrevRes(ComicsPrevResState.Loading()),
    override val series: SeriesPrevRes = SeriesPrevRes(SeriesPrevResState.Loading()),
    override val stories: StoriesPrevRes = StoriesPrevRes(StoriesPrevResState.Loading()),
    override val chars: CharsPrevRes = CharsPrevRes(CharsPrevResState.Loading()),
) : Event
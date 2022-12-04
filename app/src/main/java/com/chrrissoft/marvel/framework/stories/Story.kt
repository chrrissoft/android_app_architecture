package com.chrrissoft.marvel.framework.stories

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevResState
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState
import com.chrrissoft.marvel.data.stories.Story
import com.chrrissoft.marvel.data.stories.res.StoryRes
import com.chrrissoft.marvel.data.stories.res.StoryResState

data class Story(
    override val self: StoryRes = StoryRes(StoryResState.Loading()),
    override val events: EventsPrevRes = EventsPrevRes(EventsPrevResState.Loading()),
    override val comics: ComicsPrevRes = ComicsPrevRes(ComicsPrevResState.Loading()),
    override val series: SeriesPrevRes = SeriesPrevRes(SeriesPrevResState.Loading()),
    override val characters: CharsPrevRes = CharsPrevRes(CharsPrevResState.Loading())
) : Story {
    override fun clean() = Story()
}
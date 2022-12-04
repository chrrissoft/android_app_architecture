package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.chars.res.charsPrevConverter
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.comics.res.comicsPrevConverter
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.events.res.eventsPrevConverter
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.seriesPrevConverter
import com.chrrissoft.marvel.data.stories.res.StoryRes
import com.chrrissoft.marvel.ui.stories.Story as UiStory
import com.chrrissoft.marvel.data.stories.res.StoryResState.Error as DataError
import com.chrrissoft.marvel.data.stories.res.StoryResState.Loading as DataLoading
import com.chrrissoft.marvel.data.stories.res.StoryResState.Success as DataSuccess
import com.chrrissoft.marvel.ui.stories.res.StoryRes as UiStoryRes
import com.chrrissoft.marvel.ui.stories.res.StoryResState.Error as UiError
import com.chrrissoft.marvel.ui.stories.res.StoryResState.Loading as UiLoading
import com.chrrissoft.marvel.ui.stories.res.StoryResState.Success as UiSuccess


interface Story {

    private companion object {
        private fun storyConverter(res: StoryRes): UiStoryRes {
            return when (res.state) {
                is DataError -> UiStoryRes(UiError(res.state.throwable))
                is DataLoading -> UiStoryRes(UiLoading(res.state.message))
                is DataSuccess -> UiStoryRes(UiSuccess(res.state.id, res.state.title, res.state.image))
            }
        }
    }

    val self: StoryRes
    val events: EventsPrevRes
    val comics: ComicsPrevRes
    val series: SeriesPrevRes
    val characters: CharsPrevRes

    fun toUi() = UiStory(
        self = storyConverter(self),
        characters = charsPrevConverter(characters),
        events = eventsPrevConverter(events),
        comics = comicsPrevConverter(comics),
        series = seriesPrevConverter(series)
    )

    fun clean() : Story

}
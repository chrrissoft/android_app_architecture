package com.chrrissoft.marvel.data.events

import com.chrrissoft.marvel.data.chars.res.charsPrevConverter
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.comicsPrevConverter
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.seriesPrevConverter
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.storiesPrevConverter
import com.chrrissoft.marvel.ui.events.Event
import com.chrrissoft.marvel.data.events.res.EventResState.Error as DataError
import com.chrrissoft.marvel.data.events.res.EventResState.Loading as DataLoading
import com.chrrissoft.marvel.data.events.res.EventResState.Success as DataSuccess
import com.chrrissoft.marvel.ui.events.res.EventRes as UiEventRes
import com.chrrissoft.marvel.ui.events.res.EventResState.Error as UiError
import com.chrrissoft.marvel.ui.events.res.EventResState.Loading as UiLoading
import com.chrrissoft.marvel.ui.events.res.EventResState.Success as UiSuccess


interface Event {

    private companion object {
        private fun eventConverter(res: EventRes): UiEventRes {
            return when (res.state) {
                is DataError -> UiEventRes(UiError(res.state.throwable))
                is DataLoading -> UiEventRes(UiLoading(res.state.message))
                is DataSuccess -> UiEventRes(UiSuccess(res.state.id, res.state.title, res.state.image))
            }
        }
    }

    val self: EventRes
    val comics: ComicsPrevRes
    val series: SeriesPrevRes
    val stories: StoriesPrevRes
    val chars: CharsPrevRes

    fun toUi() = Event(
        self = eventConverter(self),
        comics = comicsPrevConverter(comics),
        series = seriesPrevConverter(series),
        stories = storiesPrevConverter(stories),
        characters = charsPrevConverter(chars),
    )
}

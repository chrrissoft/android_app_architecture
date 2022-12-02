package com.chrrissoft.marvel.data.series

import com.chrrissoft.marvel.data.chars.res.charsPrevConverter
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.comicsPrevConverter
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.eventsPrevConverter
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SerieRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.storiesPrevConverter
import com.chrrissoft.marvel.ui.series.Serie
import com.chrrissoft.marvel.data.series.res.SerieResState.Error as DataError
import com.chrrissoft.marvel.data.series.res.SerieResState.Loading as DataLoading
import com.chrrissoft.marvel.data.series.res.SerieResState.Success as DataSuccess
import com.chrrissoft.marvel.ui.series.res.SerieRes as UiSerieRes
import com.chrrissoft.marvel.ui.series.res.SerieResState.Error as UiError
import com.chrrissoft.marvel.ui.series.res.SerieResState.Loading as UiLoading
import com.chrrissoft.marvel.ui.series.res.SerieResState.Success as UiSuccess


interface Serie {

    private companion object {
        private fun serieConverter(res: SerieRes): UiSerieRes {
            return when (res.state) {
                is DataError -> UiSerieRes(UiError(res.state.throwable))
                is DataLoading -> UiSerieRes(UiLoading(res.state.message))
                is DataSuccess -> UiSerieRes(UiSuccess(res.state.id, res.state.title, res.state.image))
            }
        }
    }

    val self: SerieRes
    val events: EventsPrevRes
    val comics: ComicsPrevRes
    val stories: StoriesPrevRes
    val chars: CharsPrevRes

    fun toUi() = Serie(
        self = serieConverter(self),
        events = eventsPrevConverter(events),
        comics = comicsPrevConverter(comics),
        stories = storiesPrevConverter(stories),
        characters = charsPrevConverter(chars),
    )
}
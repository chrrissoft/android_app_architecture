package com.chrrissoft.marvel.data.chars

import com.chrrissoft.marvel.data.chars.res.CharRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.comics.res.comicsPrevConverter
import com.chrrissoft.marvel.data.events.res.eventsPrevConverter
import com.chrrissoft.marvel.data.series.res.seriesPrevConverter
import com.chrrissoft.marvel.data.stories.res.storiesPrevConverter
import com.chrrissoft.marvel.ui.chars.Character
import com.chrrissoft.marvel.ui.chars.res.CharsRes as UiCharsRes
import com.chrrissoft.marvel.ui.chars.res.CharResState.Error as UiError
import com.chrrissoft.marvel.ui.chars.res.CharResState.Loading as UiLoading
import com.chrrissoft.marvel.ui.chars.res.CharResState.Success as UiSuccess
import com.chrrissoft.marvel.data.chars.res.CharResState.Error as DataError
import com.chrrissoft.marvel.data.chars.res.CharResState.Loading as DataLoading
import com.chrrissoft.marvel.data.chars.res.CharResState.Success as DataSuccess


interface Char {

    private companion object {
        private fun charConverter(res: CharRes): UiCharsRes {
            return when (res.state) {
                is DataError -> UiCharsRes(UiError(res.state.throwable))
                is DataLoading -> UiCharsRes(UiLoading(res.state.message))
                is DataSuccess -> UiCharsRes(
                    UiSuccess(res.state.id, res.state.name, res.state.image)
                )
            }
        }
    }

    val self: CharRes
    val comics: ComicsPrevRes
    val series: SeriesPrevRes
    val events: EventsPrevRes
    val stories: StoriesPrevRes

    fun toUi() = Character(
        self = charConverter(self),
        series = seriesPrevConverter(series),
        stories = storiesPrevConverter(stories),
        events = eventsPrevConverter(events),
        comics = comicsPrevConverter(comics),
    )

    fun clean() : Char

}

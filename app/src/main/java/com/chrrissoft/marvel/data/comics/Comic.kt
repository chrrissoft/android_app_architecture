package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.chars.res.charsPrevConverter
import com.chrrissoft.marvel.data.chars.res.CharsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicRes
import com.chrrissoft.marvel.data.events.res.eventsPrevConverter
import com.chrrissoft.marvel.data.events.res.EventsPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevRes
import com.chrrissoft.marvel.data.series.res.seriesPrevConverter
import com.chrrissoft.marvel.data.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.storiesPrevConverter
import com.chrrissoft.marvel.ui.comics.Comic
import com.chrrissoft.marvel.data.comics.res.ComicResState.Error as DataError
import com.chrrissoft.marvel.data.comics.res.ComicResState.Loading as DataLoading
import com.chrrissoft.marvel.data.comics.res.ComicResState.Success as DataSuccess
import com.chrrissoft.marvel.ui.comics.res.ComicRes as UiComicRes
import com.chrrissoft.marvel.ui.comics.res.ComicResState.Error as UiError
import com.chrrissoft.marvel.ui.comics.res.ComicResState.Loading as UiLoading
import com.chrrissoft.marvel.ui.comics.res.ComicResState.Success as UiSuccess


interface Comic {

    private companion object {
        private fun comicConverter(res: ComicRes): UiComicRes {
            return when (res.state) {
                is DataError -> UiComicRes(UiError(res.state.throwable))
                is DataLoading -> UiComicRes(UiLoading(res.state.message))
                is DataSuccess -> UiComicRes(UiSuccess(res.state.id, res.state.title, res.state.image))
            }
        }
    }

    val self: ComicRes
    val series: SeriesPrevRes
    val events: EventsPrevRes
    val stories: StoriesPrevRes
    val characters: CharsPrevRes

    fun toUi() = Comic(
        self = comicConverter(self),
        events = eventsPrevConverter(events),
        series = seriesPrevConverter(series),
        stories = storiesPrevConverter(stories),
        characters = charsPrevConverter(characters)
    )
}
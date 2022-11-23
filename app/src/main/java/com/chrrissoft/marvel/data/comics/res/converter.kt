package com.chrrissoft.marvel.data.comics.res

import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes as UiComicsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState.Error as DataError
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState.Success as DataSuccess
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState.Loading as DataLoading
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevResState.Error as UiError
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevResState.Success as UiSuccess
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevResState.Loading as UiLoading

fun comicsPrevConverter(res: ComicsPrevRes): UiComicsPrevRes {
    return when (res.state) {
        is DataError -> UiComicsPrevRes(UiError(res.state.data.map { it.toUi() }))
        is DataLoading -> UiComicsPrevRes(UiLoading(res.state.data.map { it.toUi() }))
        is DataSuccess -> UiComicsPrevRes(UiSuccess(res.state.data.map { it.toUi() }))
    }
}
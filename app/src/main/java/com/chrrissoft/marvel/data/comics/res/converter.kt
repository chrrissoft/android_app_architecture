package com.chrrissoft.marvel.data.comics.res

import com.chrrissoft.marvel.ui.data.comics.res.ComicsPrevRes as UiComicsPrevRes
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState.Error as DataError
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState.Success as DataSuccess
import com.chrrissoft.marvel.data.comics.res.ComicsPrevResState.Loading as DataLoading
import com.chrrissoft.marvel.ui.data.comics.res.ComicsPrevResState.Error as UiError
import com.chrrissoft.marvel.ui.data.comics.res.ComicsPrevResState.Success as UiSuccess
import com.chrrissoft.marvel.ui.data.comics.res.ComicsPrevResState.Loading as UiLoading

fun comicsPrevConverter(res: ComicsPrevRes): UiComicsPrevRes {
    return when (res.state) {
        is DataLoading -> UiComicsPrevRes(UiLoading())
        is DataError -> UiComicsPrevRes(UiError(res.state.message))
        is DataSuccess -> UiComicsPrevRes(UiSuccess(res.state.data.map { it.toUi() }))
    }
}
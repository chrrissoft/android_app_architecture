package com.chrrissoft.marvel.data.comics.res

import com.chrrissoft.marvel.data.comics.res.ComicResState.Error as DataError
import com.chrrissoft.marvel.data.comics.res.ComicResState.Loading as DataLoading
import com.chrrissoft.marvel.data.comics.res.ComicResState.Success as DataSuccess
import com.chrrissoft.marvel.ui.comics.res.ComicRes as UiComicRes
import com.chrrissoft.marvel.ui.comics.res.ComicResState.Error as UiError
import com.chrrissoft.marvel.ui.comics.res.ComicResState.Loading as UiLoading
import com.chrrissoft.marvel.ui.comics.res.ComicResState.Success as UiSuccess


fun comicConverter(res: ComicRes): UiComicRes {
    return when (res.state) {
        is DataError -> UiComicRes(UiError(res.state.message))
        is DataLoading -> UiComicRes(UiLoading(res.state.message))
        is DataSuccess -> UiComicRes(UiSuccess(res.state.title, res.state.image))
    }
}
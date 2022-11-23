package com.chrrissoft.marvel.data.chars.res

import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes as UICharsPrevRes
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState.Error as DataError
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState.Success as DataSuccess
import com.chrrissoft.marvel.data.chars.res.CharsPrevResState.Loading as DataLoading
import com.chrrissoft.marvel.ui.chars.res.CharsPrevResState.Error as UiError
import com.chrrissoft.marvel.ui.chars.res.CharsPrevResState.Success as UiSuccess
import com.chrrissoft.marvel.ui.chars.res.CharsPrevResState.Loading as UiLoading

fun charsPrevConverter(res: CharsPrevRes): UICharsPrevRes {
    return when (res.state) {
        is DataLoading -> UICharsPrevRes(UiLoading(res.state.data.map { it.toUi() }))
        is DataSuccess -> UICharsPrevRes(UiSuccess(res.state.data.map { it.toUi() }))
        is DataError -> UICharsPrevRes(UiError(res.state.data.map { it.toUi() }))
    }
}
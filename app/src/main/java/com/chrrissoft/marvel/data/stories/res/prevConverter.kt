package com.chrrissoft.marvel.data.stories.res

import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes as UiStoriesPrevRes
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState.Error as DataError
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState.Success as DataSuccess
import com.chrrissoft.marvel.data.stories.res.StoriesPrevResState.Loading as DataLoading
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevResState.Error as UiError
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevResState.Success as UiSuccess
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevResState.Loading as UiLoading

fun storiesPrevConverter(res: StoriesPrevRes): UiStoriesPrevRes {
    return when (res.state) {
        is DataLoading -> UiStoriesPrevRes(UiLoading(res.state.data.map { it.toUi() }))
        is DataError -> UiStoriesPrevRes(UiError(res.state.data.map { it.toUi() }))
        is DataSuccess -> UiStoriesPrevRes(UiSuccess(res.state.data.map { it.toUi() }))
    }
}
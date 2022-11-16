package com.chrrissoft.marvel.data.events.res

import com.chrrissoft.marvel.ui.data.events.res.EventsPrevRes as UiEventsPrevRes
import com.chrrissoft.marvel.data.events.res.EventsPrevResState.Error as DataError
import com.chrrissoft.marvel.data.events.res.EventsPrevResState.Success as DataSuccess
import com.chrrissoft.marvel.data.events.res.EventsPrevResState.Loading as DataLoading
import com.chrrissoft.marvel.ui.data.events.res.EventsPrevResState.Success as UiSuccess
import com.chrrissoft.marvel.ui.data.events.res.EventsPrevResState.Error as UiError
import com.chrrissoft.marvel.ui.data.events.res.EventsPrevResState.Loading as UiLoading

fun eventsPrevConverter(res: EventsPrevRes): UiEventsPrevRes {
    return when (res.state) {
        is DataLoading -> UiEventsPrevRes(UiLoading())
        is DataError -> UiEventsPrevRes(UiError(res.state.message))
        is DataSuccess -> UiEventsPrevRes(UiSuccess(res.state.data.map { it.toUi() }))
    }
}

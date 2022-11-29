package com.chrrissoft.marvel.data.events.res

import com.chrrissoft.marvel.data.events.res.EventResState.Error as DataError
import com.chrrissoft.marvel.data.events.res.EventResState.Loading as DataLoading
import com.chrrissoft.marvel.data.events.res.EventResState.Success as DataSuccess
import com.chrrissoft.marvel.ui.events.res.EventRes as UiEventRes
import com.chrrissoft.marvel.ui.events.res.EventResState.Error as UiError
import com.chrrissoft.marvel.ui.events.res.EventResState.Loading as UiLoading
import com.chrrissoft.marvel.ui.events.res.EventResState.Success as UiSuccess


fun eventConverter(res: EventRes): UiEventRes {
    return when (res.state) {
        is DataError -> UiEventRes(UiError(res.state.message))
        is DataLoading -> UiEventRes(UiLoading(res.state.message))
        is DataSuccess -> UiEventRes(UiSuccess(res.state.title, res.state.image))
    }
}

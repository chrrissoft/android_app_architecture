package com.chrrissoft.marvel.data.series.res

import com.chrrissoft.marvel.ui.data.series.res.SeriesPrevRes as UiSeriesPrevRes
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState.Error as DataError
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState.Success as DataSuccess
import com.chrrissoft.marvel.data.series.res.SeriesPrevResState.Loading as DataLoading
import com.chrrissoft.marvel.ui.data.series.res.SeriesPrevResState.Success as UiSuccess
import com.chrrissoft.marvel.ui.data.series.res.SeriesPrevResState.Error as UiError
import com.chrrissoft.marvel.ui.data.series.res.SeriesPrevResState.Loading as UiLoading

fun seriesPrevConverter(res: SeriesPrevRes): UiSeriesPrevRes {
    return when (res.state) {
        is DataLoading -> UiSeriesPrevRes(UiLoading())
        is DataError -> UiSeriesPrevRes(UiError(res.state.message))
        is DataSuccess -> UiSeriesPrevRes(UiSuccess(res.state.data.map { it.toUi() }))
    }
}

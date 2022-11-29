package com.chrrissoft.marvel.data.series.res

import com.chrrissoft.marvel.data.series.res.SerieResState.Error as DataError
import com.chrrissoft.marvel.data.series.res.SerieResState.Loading as DataLoading
import com.chrrissoft.marvel.data.series.res.SerieResState.Success as DataSuccess
import com.chrrissoft.marvel.ui.series.res.SerieRes as UiSerieRes
import com.chrrissoft.marvel.ui.series.res.SerieResState.Error as UiError
import com.chrrissoft.marvel.ui.series.res.SerieResState.Loading as UiLoading
import com.chrrissoft.marvel.ui.series.res.SerieResState.Success as UiSuccess


fun serieConverter(res: SerieRes): UiSerieRes {
    return when (res.state) {
        is DataError -> UiSerieRes(UiError(res.state.message))
        is DataLoading -> UiSerieRes(UiLoading(res.state.message))
        is DataSuccess -> UiSerieRes(UiSuccess(res.state.title, res.state.image))
    }
}

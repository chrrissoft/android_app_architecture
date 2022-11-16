package com.chrrissoft.marvel.ui.data.series.res

import com.chrrissoft.marvel.ui.data.series.Series

sealed interface SeriesResState {

    data class Error(
        val message: Exception
    ) : SeriesResState

    data class Success(
        val data: Series
    ) : SeriesResState

    data class Loading(
        val message: Nothing? = null
    ) : SeriesResState

}
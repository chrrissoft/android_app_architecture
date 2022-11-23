package com.chrrissoft.marvel.ui.series.res

import com.chrrissoft.marvel.ui.series.Serie

sealed interface SeriesResState {

    data class Error(
        val message: Exception
    ) : SeriesResState

    data class Success(
        val data: Serie
    ) : SeriesResState

    data class Loading(
        val message: Nothing? = null
    ) : SeriesResState

}
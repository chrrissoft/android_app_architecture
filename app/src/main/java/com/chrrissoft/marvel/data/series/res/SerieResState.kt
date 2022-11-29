package com.chrrissoft.marvel.data.series.res

import com.chrrissoft.marvel.data.series.Series

sealed interface SerieResState {

    data class Error(
        val message: Exception
    ) : SerieResState

    data class Success(
        val title: String, val image: Any?
    ) : SerieResState

    data class Loading(
        val message: Nothing? = null
    ) : SerieResState

}
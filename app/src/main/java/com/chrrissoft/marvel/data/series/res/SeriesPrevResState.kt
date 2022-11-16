package com.chrrissoft.marvel.data.series.res

import com.chrrissoft.marvel.data.series.SeriesPreview

sealed interface SeriesPrevResState {

    data class Error(
        val message: Exception
    ) : SeriesPrevResState

    data class Success(
        val data: List<SeriesPreview>
    ) : SeriesPrevResState

    data class Loading(
        val message: Nothing? = null
    ) : SeriesPrevResState

}
package com.chrrissoft.marvel.ui.series.res

import com.chrrissoft.marvel.ui.series.SeriesPreview

sealed interface SeriesPrevResState {

    data class Error(
        val data: List<SeriesPreview>,
        val message: Exception? = null
    ) : SeriesPrevResState

    data class Success(
        val data: List<SeriesPreview>
    ) : SeriesPrevResState

    data class Loading(
        val data: List<SeriesPreview> = emptyList()
    ) : SeriesPrevResState

}


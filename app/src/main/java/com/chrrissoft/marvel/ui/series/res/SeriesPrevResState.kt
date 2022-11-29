package com.chrrissoft.marvel.ui.series.res

import com.chrrissoft.marvel.ui.series.SeriesPreview

sealed interface SeriesPrevResState {

    val data: List<SeriesPreview>

    data class Error(
        override val data: List<SeriesPreview>,
        val message: Exception? = null
    ) : SeriesPrevResState

    data class Success(
        override val data: List<SeriesPreview>
    ) : SeriesPrevResState

    data class Loading(
        override val data: List<SeriesPreview> = emptyList()
    ) : SeriesPrevResState

}


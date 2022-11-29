package com.chrrissoft.marvel.data.series.res

import com.chrrissoft.marvel.data.series.SeriesPreview

sealed interface SeriesPrevResState {

    data class Error(
        val data: List<SeriesPreview>,
        val message: Exception? = null
    ) : SeriesPrevResState

    data class Success(
        val data: List<SeriesPreview>
    ) : SeriesPrevResState

    data class Loading(
        val data: List<SeriesPreview> = emptyList(),
        ) : SeriesPrevResState

}
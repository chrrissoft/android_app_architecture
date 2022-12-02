package com.chrrissoft.marvel.data.series.res

import com.chrrissoft.marvel.data.series.SeriesPreview

sealed interface SeriesPrevResState {

    val data: List<SeriesPreview>

    data class Error(
        override val data: List<SeriesPreview>,
        val throwable: Throwable
    ) : SeriesPrevResState

    data class Success(
        override val data: List<SeriesPreview>
    ) : SeriesPrevResState

    data class Loading(
        override val data: List<SeriesPreview> = emptyList(),
    ) : SeriesPrevResState

}

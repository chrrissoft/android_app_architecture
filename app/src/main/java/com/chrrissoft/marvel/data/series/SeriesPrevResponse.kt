package com.chrrissoft.marvel.data.series

import com.chrrissoft.marvel.data.preview.SeriesPreview


interface SeriesPrevResponse {

    val resState: SeriesPrevResState

    interface LocalSeriesPrevResponse : SeriesPrevResponse
    interface RemoteSeriesPrevResponse : SeriesPrevResponse

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

}
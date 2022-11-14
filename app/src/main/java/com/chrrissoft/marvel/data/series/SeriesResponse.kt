package com.chrrissoft.marvel.data.series


interface SeriesResponse {

    val resState: SeriesResState

    interface LocalSeriesResponse : SeriesResponse
    interface RemoteSeriesResponse : SeriesResponse


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
}

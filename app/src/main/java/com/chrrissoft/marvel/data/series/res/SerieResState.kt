package com.chrrissoft.marvel.data.series.res


sealed interface SerieResState {

    data class Error(
        val throwable: Throwable
    ) : SerieResState

    data class Success(
        val id: Int, val title: String, val image: Any?
    ) : SerieResState

    data class Loading(
        val message: Nothing? = null
    ) : SerieResState

}

package com.chrrissoft.marvel.data.comics


interface ComicsResponse {

    val resState: ComicsResState

    interface LocalComicsResponse : ComicsResponse
    interface RemoteComicsResponse : ComicsResponse


    sealed interface ComicsResState {

        data class ComicError(
            val message: Exception
        ) : ComicsResState

        data class ComicSuccess(
            val data: Comic
        ) : ComicsResState

        data class ComicLoading(
            val message: Nothing? = null
        ) : ComicsResState

    }
}

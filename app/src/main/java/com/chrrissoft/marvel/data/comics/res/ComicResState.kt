package com.chrrissoft.marvel.data.comics.res


sealed interface ComicResState {

    data class Error(
        val throwable: Throwable
    ) : ComicResState

    data class Success(
        val id: Int, val title: String, val image: Any?
    ) : ComicResState

    data class Loading(
        val message: Nothing? = null
    ) : ComicResState

}

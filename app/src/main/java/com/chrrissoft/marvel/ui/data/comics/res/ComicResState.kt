package com.chrrissoft.marvel.ui.data.comics.res

import com.chrrissoft.marvel.ui.data.comics.Comic

sealed interface ComicResState {

    data class Error(
        val message: Exception
    ) : ComicResState

    data class Success(
        val data: Comic
    ) : ComicResState

    data class Loading(
        val message: Nothing? = null
    ) : ComicResState

}
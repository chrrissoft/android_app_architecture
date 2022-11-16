package com.chrrissoft.marvel.ui.data.comics.res

import com.chrrissoft.marvel.ui.data.comics.ComicPreview


sealed interface ComicsPrevResState {

    data class Error(
        val message: Exception
    ) : ComicsPrevResState

    data class Success(
        val data: List<ComicPreview>
    ) : ComicsPrevResState

    data class Loading(
        val message: Nothing? = null
    ) : ComicsPrevResState

}


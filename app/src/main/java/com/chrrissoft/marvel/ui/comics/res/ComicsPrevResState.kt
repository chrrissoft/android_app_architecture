package com.chrrissoft.marvel.ui.comics.res

import com.chrrissoft.marvel.ui.comics.ComicsPreview


sealed interface ComicsPrevResState {

    data class Error(
        val data: List<ComicsPreview>,
        val message: Exception? = null
    ) : ComicsPrevResState

    data class Success(
        val data: List<ComicsPreview>
    ) : ComicsPrevResState

    data class Loading(
        val data: List<ComicsPreview>
    ) : ComicsPrevResState

}


package com.chrrissoft.marvel.ui.comics.res

import com.chrrissoft.marvel.ui.comics.ComicsPreview


sealed interface ComicsPrevResState {

    val data: List<ComicsPreview>

    data class Error(
        override val data: List<ComicsPreview> = emptyList(),
        val message: Exception? = null
    ) : ComicsPrevResState

    data class Success(
        override val data: List<ComicsPreview> = emptyList()
    ) : ComicsPrevResState

    data class Loading(
        override val data: List<ComicsPreview> = emptyList()
    ) : ComicsPrevResState

}


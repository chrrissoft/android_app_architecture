package com.chrrissoft.marvel.data.comics.res

import com.chrrissoft.marvel.data.comics.ComicPreview

sealed interface ComicsPrevResState {

    val data: List<ComicPreview>

    data class Error(
        override val data: List<ComicPreview>,
        val message: Throwable
    ) : ComicsPrevResState

    data class Success(
        override val data: List<ComicPreview>
    ) : ComicsPrevResState

    data class Loading(
        override val data: List<ComicPreview> = emptyList(),
        ) : ComicsPrevResState

}

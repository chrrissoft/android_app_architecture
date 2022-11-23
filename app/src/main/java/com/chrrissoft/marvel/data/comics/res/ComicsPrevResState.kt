package com.chrrissoft.marvel.data.comics.res

import com.chrrissoft.marvel.data.comics.ComicPreview

sealed interface ComicsPrevResState {

    data class Error(
        val data: List<ComicPreview>,
        val message: Exception? = null
    ) : ComicsPrevResState

    data class Success(
        val data: List<ComicPreview>
    ) : ComicsPrevResState

    data class Loading(
        val data: List<ComicPreview>,
        ) : ComicsPrevResState

}


package com.chrrissoft.marvel.data.chars.res

import com.chrrissoft.marvel.data.chars.CharsPreview

sealed interface CharsPrevResState {

    data class Error(
        val data: List<CharsPreview>,
        val message: Exception? = null,
    ) : CharsPrevResState

    data class Success(
        val data: List<CharsPreview>
    ) : CharsPrevResState

    data class Loading(
        val data: List<CharsPreview> = emptyList()
    ) : CharsPrevResState

}
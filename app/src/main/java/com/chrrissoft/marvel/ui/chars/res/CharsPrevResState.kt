package com.chrrissoft.marvel.ui.chars.res

import com.chrrissoft.marvel.ui.chars.CharsPreview

sealed interface CharsPrevResState {

    data class Error(
        val data: List<CharsPreview> = emptyList(),
        val message: Exception? = null,
    ) : CharsPrevResState

    data class Success(
        val data: List<CharsPreview> = emptyList()
    ) : CharsPrevResState

    data class Loading(
        val data: List<CharsPreview> = emptyList()
    ) : CharsPrevResState

}


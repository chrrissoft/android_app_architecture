package com.chrrissoft.marvel.ui.chars.res

import com.chrrissoft.marvel.ui.chars.CharsPreview

sealed interface CharsPrevResState {

    val data: List<CharsPreview>

    data class Error(
        override val data: List<CharsPreview> = emptyList(),
        val message: Exception? = null,
    ) : CharsPrevResState

    data class Success(
        override val data: List<CharsPreview> = emptyList()
    ) : CharsPrevResState

    data class Loading(
        override val data: List<CharsPreview> = emptyList()
    ) : CharsPrevResState

}


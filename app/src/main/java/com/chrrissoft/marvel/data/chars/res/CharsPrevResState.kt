package com.chrrissoft.marvel.data.chars.res

import com.chrrissoft.marvel.data.chars.CharsPreview

sealed interface CharsPrevResState {

    val data: List<CharsPreview>

    data class Error(
        override val data: List<CharsPreview>,
        val message: Throwable,
    ) : CharsPrevResState

    data class Success(
        override val data: List<CharsPreview>
    ) : CharsPrevResState

    data class Loading(
        override val data: List<CharsPreview> = emptyList()
    ) : CharsPrevResState

}

package com.chrrissoft.marvel.ui.data.chars.res

import com.chrrissoft.marvel.ui.data.chars.CharsPreview

sealed interface CharsPrevResState {

    data class Error(
        val message: Exception,
        val data: List<CharsPreview>
    ) : CharsPrevResState

    data class Success(
        val data: List<CharsPreview>
    ) : CharsPrevResState

    data class Loading(
        val data: List<CharsPreview>
    ) : CharsPrevResState

}


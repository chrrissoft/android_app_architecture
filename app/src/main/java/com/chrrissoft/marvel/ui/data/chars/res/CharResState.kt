package com.chrrissoft.marvel.ui.data.chars.res

import com.chrrissoft.marvel.ui.data.chars.Character

sealed interface CharResState {

    data class Error(
        val message: Exception
    ) : CharResState

    data class Success(
        val data: Character
    ) : CharResState

    data class Loading(
        val message: Nothing? = null
    ) : CharResState

}
package com.chrrissoft.marvel.ui.chars.res

import com.chrrissoft.marvel.ui.chars.Character

sealed interface CharResState {

    data class Error(
        val message: Exception? = null
    ) : CharResState

    data class Success(
        val id: Int, val name: String, val image: Any?,
        ) : CharResState

    data class Loading(
        val message: Nothing? = null
    ) : CharResState

}
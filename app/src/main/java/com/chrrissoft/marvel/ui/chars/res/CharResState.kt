package com.chrrissoft.marvel.ui.chars.res


sealed interface CharResState {

    data class Error(
        val throwable: Throwable
    ) : CharResState

    data class Success(
        val id: Int, val name: String, val image: Any?,
        ) : CharResState

    data class Loading(
        val message: Nothing? = null
    ) : CharResState

}

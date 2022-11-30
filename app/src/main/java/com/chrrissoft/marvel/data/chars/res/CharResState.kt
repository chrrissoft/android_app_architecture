package com.chrrissoft.marvel.data.chars.res


sealed interface CharResState {

    data class Error(
        val message: Exception
    ) : CharResState

    data class Success(
        val id: Int, val name: String, val image: Any?,
    ) : CharResState

    data class Loading(
        val message: Nothing? = null
    ) : CharResState

}

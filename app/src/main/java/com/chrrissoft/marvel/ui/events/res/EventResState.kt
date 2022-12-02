package com.chrrissoft.marvel.ui.events.res


sealed interface EventResState {

    data class Error(
        val throwable: Throwable
    ) : EventResState

    data class Success(
        val id: Int, val title: String, val image: Any?
    ) : EventResState

    data class Loading(
        val message: Nothing? = null
    ) : EventResState

}
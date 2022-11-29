package com.chrrissoft.marvel.ui.events.res

import com.chrrissoft.marvel.ui.events.Event

sealed interface EventResState {

    data class Error(
        val message: Exception
    ) : EventResState

    data class Success(
        val title: String, val image: Any?
    ) : EventResState

    data class Loading(
        val message: Nothing? = null
    ) : EventResState

}
package com.chrrissoft.marvel.data.events.res

import com.chrrissoft.marvel.data.events.Event

sealed interface EventResState {

    data class Error(
        val message: Exception
    ) : EventResState

    data class Success(
        val data: Event
    ) : EventResState

    data class Loading(
        val message: Nothing? = null
    ) : EventResState

}
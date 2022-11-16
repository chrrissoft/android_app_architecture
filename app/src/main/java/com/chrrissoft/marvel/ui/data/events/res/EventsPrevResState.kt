package com.chrrissoft.marvel.ui.data.events.res

import com.chrrissoft.marvel.ui.data.events.EventPreview

sealed interface EventsPrevResState {

    data class Error(
        val message: Exception
    ) : EventsPrevResState

    data class Success(
        val data: List<EventPreview>
    ) : EventsPrevResState

    data class Loading(
        val message: Nothing? = null
    ) : EventsPrevResState

}


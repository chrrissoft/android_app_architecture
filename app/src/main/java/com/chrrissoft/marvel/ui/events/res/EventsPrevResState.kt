package com.chrrissoft.marvel.ui.events.res

import com.chrrissoft.marvel.ui.events.EventPreview

sealed interface EventsPrevResState {

    data class Error(
        val data: List<EventPreview>,
        val message: Exception? = null,
    ) : EventsPrevResState

    data class Success(
        val data: List<EventPreview>
    ) : EventsPrevResState

    data class Loading(
        val data: List<EventPreview> = emptyList()
    ) : EventsPrevResState

}


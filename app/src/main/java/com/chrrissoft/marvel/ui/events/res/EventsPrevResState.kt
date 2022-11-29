package com.chrrissoft.marvel.ui.events.res

import com.chrrissoft.marvel.ui.events.EventPreview

sealed interface EventsPrevResState {

    val data: List<EventPreview>

    data class Error(
        override val data: List<EventPreview>,
        val message: Exception? = null,
    ) : EventsPrevResState

    data class Success(
        override val data: List<EventPreview>
    ) : EventsPrevResState

    data class Loading(
        override val data: List<EventPreview> = emptyList()
    ) : EventsPrevResState

}


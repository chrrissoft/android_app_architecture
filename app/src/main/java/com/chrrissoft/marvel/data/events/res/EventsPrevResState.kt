package com.chrrissoft.marvel.data.events.res

import com.chrrissoft.marvel.data.events.EventPreview

sealed interface EventsPrevResState {

    val data: List<EventPreview>

    data class Error(
        override val data: List<EventPreview>,
        val throwable: Throwable
    ) : EventsPrevResState

    data class Success(
        override val data: List<EventPreview>
    ) : EventsPrevResState

    data class Loading(
        override val data: List<EventPreview> = emptyList(),
    ) : EventsPrevResState

}

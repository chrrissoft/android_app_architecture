package com.chrrissoft.marvel.data.events.res

import com.chrrissoft.marvel.data.events.EventPreview

sealed interface EventsPrevResState {

    data class Error(
        val data: List<EventPreview>,
        val message: Exception? = null
    ) : EventsPrevResState

    data class Success(
        val data: List<EventPreview>
    ) : EventsPrevResState

    data class Loading(
        val data: List<EventPreview> = emptyList(),
    ) : EventsPrevResState

}
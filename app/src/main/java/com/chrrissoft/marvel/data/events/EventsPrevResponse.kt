package com.chrrissoft.marvel.data.events

import com.chrrissoft.marvel.data.preview.EventPreview

interface EventsPrevResponse {

    val resState: EventsPrevResState

    interface LocalEventsPrevResponse : EventsPrevResponse
    interface RemoteEventsPrevResponse : EventsPrevResponse

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
}
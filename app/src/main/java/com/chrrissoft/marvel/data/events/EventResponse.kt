package com.chrrissoft.marvel.data.events


interface EventResponse {

    val resState: EventsResState

    interface LocalEventsResponse : EventResponse
    interface RemoteEventsResponse : EventResponse

    sealed interface EventsResState {

        data class Error(
            val message: Exception
        ) : EventsResState

        data class Success(
            val data: Event
        ) : EventsResState

        data class Loading(
            val message: Nothing? = null
        ) : EventsResState

    }
}

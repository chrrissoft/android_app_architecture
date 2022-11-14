package com.chrrissoft.marvel.data.stories


interface StoriesResponse {

    val resState: StoriesResState

    interface LocalStoriesResponse : StoriesResponse
    interface RemoteStoriesResponse : StoriesResponse


    sealed interface StoriesResState {

        data class Error(
            val message: Exception
        ) : StoriesResState

        data class Success(
            val data: Stories
        ) : StoriesResState

        data class Loading(
            val message: Nothing? = null
        ) : StoriesResState

    }
}

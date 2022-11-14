package com.chrrissoft.marvel.data.stories

import com.chrrissoft.marvel.data.preview.StoriesPreview


interface StoriesPrevResponse {

    val resState: StoriesPrevResState

    interface LocalStoriesPrevResponse : StoriesPrevResponse
    interface RemoteStoriesPrevResponse : StoriesPrevResponse

    sealed interface StoriesPrevResState {

        data class Error(
            val message: Exception
        ) : StoriesPrevResState

        data class Success(
            val data: List<StoriesPreview>
        ) : StoriesPrevResState

        data class Loading(
            val message: Nothing? = null
        ) : StoriesPrevResState

    }

}
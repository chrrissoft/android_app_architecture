package com.chrrissoft.marvel.data.comics

import com.chrrissoft.marvel.data.preview.ComicPreview


interface ComicsPrevResponse {

    val resState: ComicsPrevResState

    interface LocalComicsPrevResponse : ComicsPrevResponse
    interface RemoteComicsPrevResponse : ComicsPrevResponse

    sealed interface ComicsPrevResState {

        data class Error(
            val message: Exception
        ) : ComicsPrevResState

        data class Success(
            val data: List<ComicPreview>
        ) : ComicsPrevResState

        data class Loading(
            val message: Nothing? = null
        ) : ComicsPrevResState

    }

}
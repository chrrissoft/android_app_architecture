package com.chrrissoft.marvel.ui.stories.res


sealed interface StoryResState {

    data class Error(
        val throwable: Throwable
    ) : StoryResState

    data class Success(
        val id: Int, val title: String, val image: Any?
    ) : StoryResState

    data class Loading(
        val message: Nothing? = null
    ) : StoryResState

}

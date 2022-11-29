package com.chrrissoft.marvel.data.stories.res

import com.chrrissoft.marvel.data.stories.Stories

sealed interface StoryResState {

    data class Error(
        val message: Exception
    ) : StoryResState

    data class Success(
        val title: String, val image: Any?
    ) : StoryResState

    data class Loading(
        val message: Nothing? = null
    ) : StoryResState

}
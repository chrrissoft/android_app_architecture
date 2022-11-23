package com.chrrissoft.marvel.ui.stories.res

import com.chrrissoft.marvel.ui.stories.Story

sealed interface StoriesResState {

    data class Error(
        val message: Exception
    ) : StoriesResState

    data class Success(
        val data: Story
    ) : StoriesResState

    data class Loading(
        val message: Nothing? = null
    ) : StoriesResState

}
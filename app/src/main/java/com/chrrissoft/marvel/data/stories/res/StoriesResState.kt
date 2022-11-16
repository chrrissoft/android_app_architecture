package com.chrrissoft.marvel.data.stories.res

import com.chrrissoft.marvel.data.stories.Stories

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
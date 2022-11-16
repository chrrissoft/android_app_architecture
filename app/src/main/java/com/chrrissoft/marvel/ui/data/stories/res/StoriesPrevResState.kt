package com.chrrissoft.marvel.ui.data.stories.res

import com.chrrissoft.marvel.ui.data.stories.StoriesPreview

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


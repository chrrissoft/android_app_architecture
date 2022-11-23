package com.chrrissoft.marvel.ui.stories.res

import com.chrrissoft.marvel.ui.stories.StoryPreview

sealed interface StoriesPrevResState {

    data class Error(
        val data: List<StoryPreview>,
        val message: Exception? = null
    ) : StoriesPrevResState

    data class Success(
        val data: List<StoryPreview>
    ) : StoriesPrevResState

    data class Loading(
        val data: List<StoryPreview>
    ) : StoriesPrevResState

}


package com.chrrissoft.marvel.ui.stories.res

import com.chrrissoft.marvel.ui.stories.StoryPreview

sealed interface StoriesPrevResState {

    val data: List<StoryPreview>

    data class Error(
        override val data: List<StoryPreview> = emptyList(),
        val message: Exception? = null
    ) : StoriesPrevResState

    data class Success(
        override val data: List<StoryPreview>
    ) : StoriesPrevResState

    data class Loading(
        override val data: List<StoryPreview> = emptyList()
    ) : StoriesPrevResState

}


package com.chrrissoft.marvel.data.stories.res

import com.chrrissoft.marvel.data.stories.StoriesPreview


sealed interface StoriesPrevResState {

    data class Error(
        val data: List<StoriesPreview>,
        val throwable: Throwable,
    ) : StoriesPrevResState

    data class Success(
        val data: List<StoriesPreview>
    ) : StoriesPrevResState

    data class Loading(
        val data: List<StoriesPreview> = emptyList(),
        ) : StoriesPrevResState

}


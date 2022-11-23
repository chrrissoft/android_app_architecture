package com.chrrissoft.marvel.ui.stories.res

import com.chrrissoft.marvel.ui.stories.res.StoriesResState.Loading

data class StoriesRes(
    val data: StoriesResState = Loading()
)
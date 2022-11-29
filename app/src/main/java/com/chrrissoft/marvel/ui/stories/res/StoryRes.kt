package com.chrrissoft.marvel.ui.stories.res

import com.chrrissoft.marvel.ui.stories.res.StoryResState.Loading

data class StoryRes(
    val state: StoryResState = Loading()
)
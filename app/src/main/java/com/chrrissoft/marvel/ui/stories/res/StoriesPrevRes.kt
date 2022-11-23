package com.chrrissoft.marvel.ui.stories.res

import com.chrrissoft.marvel.ui.stories.res.StoriesPrevResState.Loading


data class StoriesPrevRes(
    val state: StoriesPrevResState = Loading(emptyList())
)


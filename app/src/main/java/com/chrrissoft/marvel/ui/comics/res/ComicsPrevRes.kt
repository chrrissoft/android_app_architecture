package com.chrrissoft.marvel.ui.comics.res

import com.chrrissoft.marvel.ui.comics.res.ComicsPrevResState.Error

data class ComicsPrevRes(
    val state: ComicsPrevResState = Error()
)


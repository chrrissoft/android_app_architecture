package com.chrrissoft.marvel.ui.comics.res

import com.chrrissoft.marvel.ui.comics.res.ComicResState.Loading

data class ComicRes(
    val state: ComicResState = Loading()
)
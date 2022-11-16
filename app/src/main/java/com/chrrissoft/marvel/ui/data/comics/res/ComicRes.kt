package com.chrrissoft.marvel.ui.data.comics.res

import com.chrrissoft.marvel.ui.data.comics.res.ComicResState.Loading

data class ComicRes(
    val data: ComicResState = Loading()
)
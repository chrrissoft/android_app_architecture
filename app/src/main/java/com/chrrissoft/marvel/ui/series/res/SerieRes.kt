package com.chrrissoft.marvel.ui.series.res

import com.chrrissoft.marvel.ui.series.res.SerieResState.Loading


data class SerieRes(
    val state: SerieResState = Loading()
)
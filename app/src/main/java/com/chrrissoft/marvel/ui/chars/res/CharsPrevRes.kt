package com.chrrissoft.marvel.ui.chars.res

import com.chrrissoft.marvel.ui.chars.res.CharsPrevResState.Loading


data class CharsPrevRes(
    val state: CharsPrevResState = CharsPrevResState.Error()
)
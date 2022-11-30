package com.chrrissoft.marvel.ui.chars.res

import com.chrrissoft.marvel.ui.chars.res.CharResState.Loading

data class CharsRes(
    val state: CharResState = Loading()
)
package com.chrrissoft.marvel.ui.chars.res

import com.chrrissoft.marvel.ui.chars.res.CharResState.Error

data class CharsRes(
    val state: CharResState = Error()
)
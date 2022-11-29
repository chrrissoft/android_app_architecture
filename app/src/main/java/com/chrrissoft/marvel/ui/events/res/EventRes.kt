package com.chrrissoft.marvel.ui.events.res

import com.chrrissoft.marvel.ui.events.res.EventResState.Loading

data class EventRes(
    val state: EventResState = Loading()
)
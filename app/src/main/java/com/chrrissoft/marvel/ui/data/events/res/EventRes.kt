package com.chrrissoft.marvel.ui.data.events.res

import com.chrrissoft.marvel.ui.data.events.res.EventResState.Loading

data class EventRes(
    val data: EventResState = Loading()
)
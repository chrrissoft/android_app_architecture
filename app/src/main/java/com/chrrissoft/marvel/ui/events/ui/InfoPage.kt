package com.chrrissoft.marvel.ui.events.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.chrrissoft.marvel.ui.events.Event
import com.chrrissoft.marvel.ui.events.EventsScreenState.InfoResState

@Composable
internal fun EventInfoPage(
    info: Event,
    resState: InfoResState
) {
    if (info.isEmpty()) {
        Text(text = "Select a preview for watch an info")
    } else {
        Text(text = info.title)
    }
}
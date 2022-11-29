package com.chrrissoft.marvel.ui.events

import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW
import com.chrrissoft.marvel.ui.events.res.EventRes
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes

data class EventsScreenState(
    val screenPage: ScreenPage = PREVIEW,
    val info: Event = Event.emptyEvent,
    val previews: EventsPrevRes = EventsPrevRes(),
)

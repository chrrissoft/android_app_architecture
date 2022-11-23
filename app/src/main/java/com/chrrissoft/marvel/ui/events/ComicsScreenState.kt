package com.chrrissoft.marvel.ui.events

import com.chrrissoft.marvel.ui.events.EventsScreenState.PreviewResState.LOADING as PREVIEW_LOADING
import com.chrrissoft.marvel.ui.events.EventsScreenState.InfoResState.LOADING as INFO_LOADING
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW

data class EventsScreenState(
    val screenPage: ScreenPage = PREVIEW,
    val info: Event = Event.emptyEvent,
    val infoResState: InfoResState = INFO_LOADING,
    val previews: List<EventPreview> = emptyList(),
    val previewResState: PreviewResState = PREVIEW_LOADING,
) {
    enum class PreviewResState {
        LOADING, ERROR, SUCCESS
    }

    enum class InfoResState {
        LOADING, ERROR, SUCCESS
    }
}
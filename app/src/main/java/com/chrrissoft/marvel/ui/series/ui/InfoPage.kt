package com.chrrissoft.marvel.ui.series.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.chrrissoft.marvel.ui.comics.Comic
import com.chrrissoft.marvel.ui.comics.ComicsScreenState
import com.chrrissoft.marvel.ui.events.Event
import com.chrrissoft.marvel.ui.events.EventsScreenState
import com.chrrissoft.marvel.ui.series.Serie
import com.chrrissoft.marvel.ui.series.SeriesScreenState

@Composable
internal fun SerieInfoPage(
    info: Serie,
    resState: SeriesScreenState.InfoResState
) {
    if (info.isEmpty()) {
        Text(text = "Select a preview for watch an info")
    } else {
        Text(text = info.title)
    }
}
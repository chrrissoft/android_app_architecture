package com.chrrissoft.marvel.ui.events.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chrrissoft.marvel.ui.INFO_STATE
import com.chrrissoft.marvel.ui.common.info.EmptyInfo
import com.chrrissoft.marvel.ui.events.Event
import com.chrrissoft.marvel.ui.events.res.EventRes
import com.chrrissoft.marvel.ui.events.res.EventResState.*
import com.chrrissoft.marvel.ui.common.info.ErrorInfo
import com.chrrissoft.marvel.ui.common.info.LoadingInfo
import com.chrrissoft.marvel.ui.common.info.SuccessInfo
import com.chrrissoft.marvel.ui.common.info.preview.*

@Composable
fun EventsInfoPage(
    res: Event,
    modifier: Modifier = Modifier,
    onLoadEvent: () -> Unit,
    onLoadChars: () -> Unit,
    loadComics: () -> Unit,
    onLoadSeries: () -> Unit,
    onLoadStories: () -> Unit,
) {

    if (res.isEmpty()) EmptyInfo()

    else {
        Column(
            modifier
                .fillMaxSize()
                .background(colorScheme.secondaryContainer)
                .verticalScroll(rememberScrollState())
        ) {
            Info(res.self) { onLoadEvent() }
            Spacer(Modifier.height(5.dp))
            CharsPreviewsInInfo(res.characters) { onLoadChars() }
            ComicsPreviewsInInfo(res.comics) { loadComics() }
            SeriesPreviewsInInfo(res.series) { onLoadSeries() }
            StoriesPreviewsInInfo(res.stories) { onLoadStories() }
        }
    }
}

@Composable
private fun Info(res: EventRes, onTryAgain: () -> Unit) {
    Log.d(INFO_STATE, "Event info   ->   ${res.state}")
    when (res.state) {
        is Error -> ErrorInfo { onTryAgain() }
        is Loading -> LoadingInfo()
        is Success -> SuccessInfo(res.state.title, res.state.image)
    }
}

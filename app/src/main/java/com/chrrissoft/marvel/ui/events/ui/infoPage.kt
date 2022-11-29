package com.chrrissoft.marvel.ui.events.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    onLoadMore: () -> Unit,
) {
    Column(
        modifier
            .fillMaxSize()
            .background(colorScheme.secondaryContainer)
            .verticalScroll(rememberScrollState())
    ) {
        Info(res.self)
        Spacer(Modifier.height(5.dp))
        CharsPreviewsInInfo(res.characters) { }
        ComicsPreviewsInInfo(res.comics) { }
        SeriesPreviewsInInfo(res.series) { }
        StoriesPreviewsInInfo(res.stories) { }
    }
}

@Composable
private fun Info(res: EventRes) {
    when (res.state) {
        is Error -> ErrorInfo()
        is Loading -> LoadingInfo()
        is Success -> SuccessInfo(res.state.title)
    }
}
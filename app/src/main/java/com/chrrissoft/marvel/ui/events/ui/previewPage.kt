package com.chrrissoft.marvel.ui.events.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrrissoft.marvel.ui.PREVIEW_STATE
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.events.res.EventsPrevResState.*
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevError
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevLoading
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevSuccess
import com.chrrissoft.marvel.ui.events.EventPreview

@Composable
fun EventsPreviewPage(
    res: EventsPrevRes,
    listState: LazyListState,
    modifier: Modifier = Modifier,
    onLoad: () -> Unit,
    onGetInfo: (Int) -> Unit,
) {
    Log.d(PREVIEW_STATE, "Events   ->   ${res.state}")
    Box(
        modifier
            .fillMaxSize()
            .background(colorScheme.secondaryContainer)
    ) {
        LazyRow(state = listState) {
            list(res.state.data) {  onGetInfo(it)  }
            when (res.state) {
                is Error -> item { EventsPreviewError { onLoad() } }
                is Loading -> item { EventsPreviewLoading() }
                is Success -> { item { Button(onLoad) { } }}
            }
        }
    }
}

private fun LazyListScope.list(
    list: List<EventPreview>,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    items(list) { EventsPreviewSuccess(it, modifier) { onClick(it.id) } }
}

@Composable
private fun EventsPreviewError(modifier: Modifier = Modifier, onTryAgain: () -> Unit) {
    PrevOnPrevError(modifier) { onTryAgain() }
}

@Composable
private fun EventsPreviewLoading(modifier: Modifier = Modifier) {
    Column(modifier) {
        PrevOnPrevLoading()
        PrevOnPrevLoading()
        PrevOnPrevLoading()
    }
}

@Composable
private fun EventsPreviewSuccess(
    preview: EventPreview,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    PrevOnPrevSuccess(preview.title, preview.image, modifier) { onClick() }
}

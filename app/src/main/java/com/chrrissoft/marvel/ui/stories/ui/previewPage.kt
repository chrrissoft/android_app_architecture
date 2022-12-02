package com.chrrissoft.marvel.ui.stories.ui

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
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevResState.*
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevError
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevLoading
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevSuccess
import com.chrrissoft.marvel.ui.stories.StoryPreview

@Composable
fun StoriesPreviewPage(
    res: StoriesPrevRes,
    listState: LazyListState,
    modifier: Modifier = Modifier,
    onLoad: () -> Unit,
    onGetInfo: (Int) -> Unit,
) {
    Log.d(PREVIEW_STATE, "Stories   ->   ${res.state}")
    Box(
        modifier
            .fillMaxSize()
            .background(colorScheme.secondaryContainer)
    ) {
        LazyRow(state = listState) {
            list(res.state.data) { onGetInfo(it) }
            when (res.state) {
                is Error -> item { StoriesPreviewError { onLoad() } }
                is Loading -> item { StoriesPreviewLoading() }
                is Success -> { item { Button(onLoad) { } }}
            }
        }
    }
}

private fun LazyListScope.list(
    list: List<StoryPreview>,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    items(list) { StoriesPreviewSuccess(it, modifier) { onClick(it.id) } }
}

@Composable
private fun StoriesPreviewError(modifier: Modifier = Modifier, onTryAgain: () -> Unit) {
    PrevOnPrevError(modifier) { onTryAgain() }
}

@Composable
private fun StoriesPreviewLoading(modifier: Modifier = Modifier) {
    Column(modifier) {
        PrevOnPrevLoading()
        PrevOnPrevLoading()
        PrevOnPrevLoading()
    }
}

@Composable
private fun StoriesPreviewSuccess(
    preview: StoryPreview,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    PrevOnPrevSuccess(preview.title, preview.image, modifier) { onClick() }
}

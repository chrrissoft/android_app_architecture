package com.chrrissoft.marvel.ui.chars.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrrissoft.marvel.ui.chars.CharsPreview
import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.chars.res.CharsPrevResState.*
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevError
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevLoading
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevSuccess

@Composable
fun CharsPreviewPage(
    res: CharsPrevRes,
    modifier: Modifier = Modifier,
    onLoad: () -> Unit
) {
    Box(
        modifier
            .fillMaxSize()
            .background(colorScheme.secondaryContainer)
    ) {
        LazyRow {
            list(res.state.data)
            when (res.state) {
                is Error -> item { CharsPreviewError() }
                is Loading -> item { CharsPreviewLoading() }
                is Success -> { item { Button(onLoad) { } }}
            }
        }
    }
}

private fun LazyListScope.list(list: List<CharsPreview>) {
    items(list) { CharsPreviewSuccess(it) }
}

@Composable
private fun CharsPreviewError(modifier: Modifier = Modifier) {
    PrevOnPrevError(modifier)
}

@Composable
private fun CharsPreviewLoading(modifier: Modifier = Modifier) {
    Column(modifier) {
        PrevOnPrevLoading()
        PrevOnPrevLoading()
        PrevOnPrevLoading()
    }
}

@Composable
private fun CharsPreviewSuccess(preview: CharsPreview, modifier: Modifier = Modifier) {
    PrevOnPrevSuccess(preview.name, preview.image, modifier)
}

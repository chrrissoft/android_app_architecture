package com.chrrissoft.marvel.ui.comics.ui

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
import com.chrrissoft.marvel.ui.comics.ComicsPreview
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevResState.*
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevError
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevLoading
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevSuccess

@Composable
fun ComicsPreviewPage(
    res: ComicsPrevRes,
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
                is Error -> item { ComicsPreviewError() }
                is Loading -> item { ComicsPreviewLoading() }
                is Success -> { item { Button(onLoad) { } }}
            }
        }
    }
}

private fun LazyListScope.list(list: List<ComicsPreview>) {
    items(list) { ComicsPreviewSuccess(it) }
}

@Composable
private fun ComicsPreviewError(modifier: Modifier = Modifier) {
    PrevOnPrevError(modifier)
}

@Composable
private fun ComicsPreviewLoading(modifier: Modifier = Modifier) {
    Column(modifier) {
        PrevOnPrevLoading()
        PrevOnPrevLoading()
        PrevOnPrevLoading()
    }
}

@Composable
private fun ComicsPreviewSuccess(preview: ComicsPreview, modifier: Modifier = Modifier) {
    PrevOnPrevSuccess(preview.title, preview.image, modifier)
}

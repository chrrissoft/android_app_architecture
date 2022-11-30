package com.chrrissoft.marvel.ui.series.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrrissoft.marvel.ui.chars.ui.PREVIEW_STATE
import com.chrrissoft.marvel.ui.series.res.SeriesPrevRes
import com.chrrissoft.marvel.ui.series.res.SeriesPrevResState.*
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevError
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevLoading
import com.chrrissoft.marvel.ui.common.previews.PrevOnPrevSuccess
import com.chrrissoft.marvel.ui.series.SeriesPreview

@Composable
fun SeriesPreviewPage(
    res: SeriesPrevRes,
    modifier: Modifier = Modifier,
    onLoad: () -> Unit
) {
    Log.d(PREVIEW_STATE, "Series   ->   ${res.state}")
    Box(
        modifier
            .fillMaxSize()
            .background(colorScheme.secondaryContainer)
    ) {
        LazyRow {
            list(res.state.data)
            when (res.state) {
                is Error -> item { SeriesPreviewError() }
                is Loading -> item { SeriesPreviewLoading() }
                is Success -> { item { Button(onLoad) { } }}
            }
        }
    }
}

private fun LazyListScope.list(list: List<SeriesPreview>) {
    items(list) { SeriesPreviewSuccess(it) }
}

@Composable
private fun SeriesPreviewError(modifier: Modifier = Modifier) {
    PrevOnPrevError(modifier)
}

@Composable
private fun SeriesPreviewLoading(modifier: Modifier = Modifier) {
    Column(modifier) {
        PrevOnPrevLoading()
        PrevOnPrevLoading()
        PrevOnPrevLoading()
    }
}

@Composable
private fun SeriesPreviewSuccess(preview: SeriesPreview, modifier: Modifier = Modifier) {
    PrevOnPrevSuccess(preview.title, preview.image, modifier)
}

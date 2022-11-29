package com.chrrissoft.marvel.ui.common.previews

import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ImageOnPrevError() {
    TODO()
}

@Composable
fun ImageOnPrevLoading() {
    TODO()
}

@Composable
fun ImageOnPrevSuccess(data: Any?, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(data).crossfade(true),
        contentDescription = null,
        modifier = modifier.clip(shape),
        contentScale = ContentScale.Crop,
    )
}

private val shape
    @Composable get() = shapes.medium
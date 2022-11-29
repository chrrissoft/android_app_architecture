package com.chrrissoft.marvel.ui.common.info

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.request.ImageRequest.Builder

@Composable
fun ImageOnInfoError() {
    TODO()
}

@Composable
fun ImageOnInfoLoading() {
    TODO()
}

@Composable
fun ImageOnInfoSuccess(data: Any?) {
    AsyncImage(
        model = Builder(LocalContext.current).data(data).crossfade(true),
        contentDescription = null
    )
}

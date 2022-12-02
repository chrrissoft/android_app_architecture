package com.chrrissoft.marvel.ui.common.info


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun InfoImageError(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(shapes.large)
            .background(colorScheme.error)
    ) {
        Icon(
            imageVector = Rounded.Info,
            contentDescription = null,
            tint = colorScheme.onError,
            modifier = modifier
                .align(Center)
                .fillMaxSize()
                .padding(20.dp)
        )
    }
}

@Composable
fun InfoImageLoading(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(shapes.large)
            .fillMaxSize()
            .background(colorScheme.onSecondary)
    )
}

@Composable
fun InfoImageSuccess() {
    TODO()
}

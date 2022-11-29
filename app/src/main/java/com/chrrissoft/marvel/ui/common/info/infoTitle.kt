package com.chrrissoft.marvel.ui.common.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoTitleError(modifier: Modifier = Modifier) {
    Text(
        text = "Error has been",
        modifier = modifier,
        style = typography.titleLarge.copy(colorScheme.error, letterSpacing = 2.sp)
    )
}

@Composable
fun InfoTitleLoading(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shapes.medium)
            .background(colorScheme.onSecondary)
    )
}

@Composable
fun InfoTitleSuccess(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = typography.titleMedium.copy(colorScheme.onSecondary),
        modifier = modifier.fillMaxWidth()
    )
}
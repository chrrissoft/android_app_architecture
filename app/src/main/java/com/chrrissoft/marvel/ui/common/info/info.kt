package com.chrrissoft.marvel.ui.common.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

private val modifier: (Shape, Color, Modifier) -> Modifier = { shape, color, modifier ->
    modifier.fillMaxWidth()
        .aspectRatio(1.5f)
        .padding(12.dp)
        .clip(shape)
        .background(color)
        .padding(10.dp)
}

@Composable
fun ErrorInfo(modifier: Modifier = Modifier) {
    Column(
        modifier(shapes.medium, colorScheme.errorContainer, modifier),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        InfoImageError(Modifier.weight(10f))
        Spacer(Modifier.weight(1f))
        InfoTitleError(Modifier.weight(2f))
    }
}

@Composable
fun LoadingInfo(modifier: Modifier = Modifier) {
    Column(
        modifier(shapes.medium, colorScheme.secondary, modifier),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        InfoImageLoading(Modifier.weight(10f))
        Spacer(Modifier.weight(1f))
        InfoTitleLoading(Modifier.weight(2f))
    }
}

@Composable
fun SuccessInfo(title: String) {
    Column {
        InfoImageSuccess()
        InfoTitleSuccess(title)
    }
}

package com.chrrissoft.marvel.ui.common.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

private val shape @Composable get() = shapes.medium

private val height @Composable get() = (LocalConfiguration.current.screenHeightDp / 10f).dp

private val width @Composable get() = LocalConfiguration.current.screenWidthDp.dp

private val modifier: @Composable (Color, Modifier) -> Modifier = { c, m ->
    m
        .fillMaxWidth()
        .height(height)
        .clip(shape)
        .background(c)
}

@Composable
fun PrevOnPrevError(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(width)
            .height(height.times(3))
            .padding(10.dp)
            .clip(shape)
            .background(colorScheme.errorContainer),
    ) {
        Icon(
            Rounded.Info,
            contentDescription = null,
            tint = colorScheme.onErrorContainer,
                modifier = Modifier.size(100.dp),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Has been error",
            style = typography.labelLarge.copy(colorScheme.onErrorContainer),
        )
    }
}

@Composable
fun PrevOnPrevLoading(modifier: Modifier = Modifier) {
    Box(
        modifier
            .width(width)
            .height(height)
            .padding(10.dp)
            .clip(shape)
            .background(colorScheme.secondary)
    )
}

@Composable
fun PrevOnPrevSuccess(title: String, image: Any?, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier(colorScheme.secondary, modifier),
    ) {
        ImageOnPrevSuccess(image)
        TitleOnPrevSuccess(title)
    }
}

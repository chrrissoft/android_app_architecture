package com.chrrissoft.marvel.ui.common.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

private val width
    @Composable
    get() = LocalConfiguration.current.screenWidthDp.div(2).dp

private val shape @Composable get() = shapes.medium

@Composable
fun PrevOnInfoError(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(width.times(2))
            .aspectRatio(2f)
            .padding(12.dp)
            .clip(shape)
            .background(colorScheme.errorContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(8f)
        ) {
            Icon(
                imageVector = Rounded.Info,
                contentDescription = null,
                tint = colorScheme.onErrorContainer,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Has been error",
            style = typography.titleMedium.copy(colorScheme.onErrorContainer),
            modifier = Modifier.weight(2f)
        )
    }
}

@Composable
fun PrevOnInfoLoading(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(width)
            .aspectRatio(1f)
            .padding(12.dp)
            .clip(shape)
            .background(colorScheme.secondary)
    )
}

@Composable
fun PrevOnInfoSuccess(title: String, image: Any?, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(width)
            .aspectRatio(1f)
            .padding(12.dp)
            .clip(shape)
            .background(colorScheme.errorContainer)
            .padding(12.dp)
    ) {
        Image(image)
        Title(title)
    }
}

@Composable
private fun Image(data: Any?, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest
            .Builder(LocalContext.current).data(data)
            .crossfade(true).build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxSize()
            .clip(shape),
    )
}

@Composable
private fun Title(title: String) {
    Text(text = title, style = typography.titleMedium)
}
package com.chrrissoft.marvel.ui.common.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

private val shape @Composable get() = shapes.medium

private val height @Composable get() = LocalConfiguration.current.screenHeightDp.div(6).dp

private val width @Composable get() = LocalConfiguration.current.screenWidthDp.dp

@Composable
fun PrevOnPrevError(modifier: Modifier = Modifier, onTryAgain: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(width)
            .height(height.times(2))
            .padding(10.dp)
            .clip(shape)
            .background(colorScheme.errorContainer),
    ) {
        Icon(
            Rounded.Info,
            contentDescription = null,
            tint = colorScheme.onErrorContainer,
            modifier = Modifier.size(100.dp).clickable { onTryAgain() },
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Has been error",
            style = typography.labelLarge.copy(
                colorScheme.onErrorContainer, letterSpacing = 2.sp
            ),
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
fun PrevOnPrevSuccess(
    title: String,
    image: Any?,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable { onClick() }
            .width(width)
            .height(height)
            .padding(10.dp)
            .clip(shape)
            .background(colorScheme.secondary),
    ) {
        Image(image)
        Title(title)
    }
}

@Composable
private fun Image(data: Any?, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(data).crossfade(true).build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(shape)
            .fillMaxHeight()
            .aspectRatio(1f)
            .clip(shape)
    )
}

@Composable
private fun Title(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth(),
        style = typography.titleMedium.copy(colorScheme.onSecondary, textAlign = TextAlign.Center),
    )

}
package com.chrrissoft.marvel.ui.common.previews

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion.Center

@Composable
fun TitleOnPrevError() {
    TODO()
}

@Composable
fun TitleOnPrevLoading() {
    TODO()
}

@Composable
fun TitleOnPrevSuccess(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth(),
        style = typography.titleMedium.copy(colorScheme.onSecondary, textAlign = Center),
    )
}

package com.chrrissoft.marvel.ui.common.info

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PrevListTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = typography.titleLarge.copy(colorScheme.onSecondaryContainer),
        modifier = modifier.fillMaxWidth().padding(start = 12.dp, top = 12.dp, bottom = 3.dp)
    )
}
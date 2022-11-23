package com.chrrissoft.marvel.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
internal fun CharName(text: String, fontSize: TextUnit) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleSmall.copy(
            fontSize = fontSize,
            color = colorScheme.onSecondaryContainer
        ),
        textAlign = TextAlign.Center
    )
}
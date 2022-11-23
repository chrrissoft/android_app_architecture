package com.chrrissoft.marvel.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit

@Composable
internal fun TitleContainer(
    text: String,
    fontSize: TextUnit,
    modifier: Modifier
) {
    Box(
        contentAlignment = Center,
        modifier = modifier.fillMaxWidth(),
    ) { CharName(text, fontSize) }
}

package com.chrrissoft.marvel.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AppearancesCount(
    count: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(shapes.small)
            .background(colorScheme.tertiaryContainer)
            .padding(5.dp),
        verticalAlignment = CenterVertically,
        horizontalArrangement = SpaceBetween
    ) {
        PreviewInfoText(count, text)
        Icon(
            Default.Add, contentDescription = null
        )
    }
}

@Composable
private fun PreviewInfoText(
    count: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "$text $count",
        modifier = modifier,
        style = typography.labelSmall.copy(
            colorScheme.onTertiaryContainer, fontWeight = FontWeight.Bold
        )
    )
}
package com.chrrissoft.marvel.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
internal fun Preview(
    image: Any?,
    title: String,
    appearances: @Composable ColumnScope.() -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 10.dp)
            .height(150.dp)
            .clip(shapes.medium)
            .shadow(1.dp)
            .background(colorScheme.secondaryContainer)
    ) {
        Image(
            image, modifier = Modifier
                .height(150.dp)
                .width(150.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TitleContainer(title, 10.sp, Modifier.weight(1f))
            appearances()
        }
    }
}



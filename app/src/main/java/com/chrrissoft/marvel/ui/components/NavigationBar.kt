package com.chrrissoft.marvel.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.chrrissoft.marvel.ui.common.ScreenPage

@Composable
fun MarvelNavigationBar(
    screenPage: ScreenPage,
    barColors: NavigationBarColors,
    itemColors: NavigationBarItemColors,
    onScreenPageChange: (ScreenPage) -> Unit
) {
    NavigationBar(
        contentColor = barColors.contentColor,
        containerColor = barColors.containerColor
    ) {
        val previewSelected = screenPage == ScreenPage.PREVIEW
        val infoSelected = screenPage == ScreenPage.INFO

        NavigationBarItem(
            selected = previewSelected,
            colors = itemColors,
            onClick = { onScreenPageChange(ScreenPage.PREVIEW) },
            icon = {
                val icon = if (previewSelected)
                    Icons.Filled.Add else Icons.Outlined.Add
                Icon(icon, contentDescription = null)
            }
        )

        NavigationBarItem(
            selected = infoSelected,
            colors = itemColors,
            onClick = { onScreenPageChange(ScreenPage.INFO) },
            icon = {
                val icon = if (infoSelected)
                    Icons.Filled.Add else Icons.Outlined.Add
                Icon(icon, contentDescription = null)
            }
        )
    }
}

data class NavigationBarColors(
    val containerColor: Color,
    val contentColor: Color,
)

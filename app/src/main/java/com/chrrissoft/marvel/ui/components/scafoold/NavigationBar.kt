package com.chrrissoft.marvel.ui.components

import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.chrrissoft.marvel.R.string.screen_page__info
import com.chrrissoft.marvel.R.string.screen_page__preview
import com.chrrissoft.marvel.ui.common.ScreenPage

@Composable
fun MarvelNavigationBar(
    screenPage: ScreenPage,
    barColors: MarvelNavBarColors,
    itemColors: NavigationBarItemColors,
    onScreenPageChange: (ScreenPage) -> Unit
) {
    NavigationBar(
        contentColor = barColors.contentColor,
        containerColor = barColors.containerColor
    ) {
        val previewSelected = screenPage == ScreenPage.PREVIEW
        val infoSelected = screenPage == ScreenPage.INFO

        val infoIcon = if (infoSelected) Filled.Info else Outlined.Info
        val previewIcon = if (previewSelected) Filled.Check else Outlined.Build


        NavigationBarItem(
            selected = previewSelected,
            colors = itemColors,
            onClick = { onScreenPageChange(ScreenPage.PREVIEW) },
            label = { Text(text = stringResource(screen_page__preview)) },
            icon = { Icon(previewIcon, contentDescription = null) }
        )

        NavigationBarItem(
            selected = infoSelected,
            colors = itemColors,
            label = { Text(text = stringResource(screen_page__info)) },
            onClick = { onScreenPageChange(ScreenPage.INFO) },
            icon = { Icon(infoIcon, contentDescription = null) }
        )
    }
}

data class MarvelNavBarItemColors(
    val selectedIconColor: Color,
    val selectedTextColor: Color,
    val selectedIndicatorColor: Color,
    val unselectedIconColor: Color,
    val unselectedTextColor: Color,
) {
    companion object {
        @Composable
        fun default(): NavigationBarItemColors {
            return NavigationBarItemDefaults.colors(
                indicatorColor = colorScheme.primary,
                selectedIconColor = colorScheme.onPrimary,
                selectedTextColor = colorScheme.primary,
                unselectedIconColor = colorScheme.onPrimaryContainer,
                unselectedTextColor = colorScheme.onPrimaryContainer,
            )
        }
    }
}

data class MarvelNavBarColors(
    val containerColor: Color,
    val contentColor: Color,
) {
    companion object {
        @Composable
        fun default(): MarvelNavBarColors {
            val containerColor = colorScheme.primaryContainer
            val contentColor = colorScheme.contentColorFor(containerColor)
            return MarvelNavBarColors(
                contentColor = contentColor,
                containerColor = containerColor
            )
        }
    }
}

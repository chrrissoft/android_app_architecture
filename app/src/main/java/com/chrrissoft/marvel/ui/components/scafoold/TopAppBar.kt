package com.chrrissoft.marvel.ui.components.scafoold

import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarvelTopAppBar(
    title: String,
    colors: TopAppBarColors,
    onOpenDrawer: () -> Unit,
) {
    TopAppBar(
        colors = colors,
        title = { TopAppBarTitle(title) },
        navigationIcon = { NavigationIcon { onOpenDrawer() } },
    )
}

@Composable
private fun TopAppBarTitle(
    title: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = Bold,)
    )
}

@Composable
private fun NavigationIcon(
    onOpenDrawer: () -> Unit
) {
    IconButton(onClick = { onOpenDrawer() }) {
        Icon(
            imageVector = Outlined.Menu,
            contentDescription = null,
        )
    }
}

data class MarvelTopAppBarColors(
    val containerColor: Color,
    val scrolledContainerColor: Color,
    val navigationIconContentColor: Color,
    val titleContentColor: Color,
    val actionIconContentColor: Color,
) {
    companion object {
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun default() : TopAppBarColors {
            return TopAppBarDefaults.topAppBarColors(
                containerColor = colorScheme.primaryContainer,
                titleContentColor = colorScheme.onPrimaryContainer
            )
        }
    }
}

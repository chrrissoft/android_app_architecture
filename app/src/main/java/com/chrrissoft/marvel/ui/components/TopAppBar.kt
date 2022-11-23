package com.chrrissoft.marvel.ui.components

import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.chrrissoft.marvel.ui.theme.charsOnPrimary

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
        style = MaterialTheme.typography.titleMedium.copy(
            color = colorScheme.charsOnPrimary,
            fontWeight = FontWeight.Bold,
        )
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
            tint = colorScheme.charsOnPrimary
        )
    }
}
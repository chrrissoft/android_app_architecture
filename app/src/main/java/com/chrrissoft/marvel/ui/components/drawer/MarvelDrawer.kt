package com.chrrissoft.marvel.ui.components.drawer

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.chrrissoft.marvel.ui.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarvelDrawer(
    item: Screens,
    drawerState: DrawerState,
    onCloseDrawer: () -> Unit,
    sheetColors: MarvelDrawerSheetColors,
    itemColors: NavigationDrawerItemColors,
    onItemsChange: (Screens) -> Unit,
    content: @Composable () -> Unit,
) {

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            MarvelDrawerSheet(
                item = item,
                onCloseDrawer = { onCloseDrawer() },
                sheetColors = sheetColors,
                itemColors = itemColors
            ) { onItemsChange(it) }
        }
    ) { content() }
}

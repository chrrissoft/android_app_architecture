package com.chrrissoft.marvel.ui.chars.ui

import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBarDefaults.containerColor
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.chrrissoft.marvel.R.string.route_name__chars
import com.chrrissoft.marvel.ui.chars.CharsViewModel
import com.chrrissoft.marvel.ui.common.ScreenPage.INFO
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW
import com.chrrissoft.marvel.ui.components.MarvelNavigationBar
import com.chrrissoft.marvel.ui.components.MarvelScaffold
import com.chrrissoft.marvel.ui.components.MarvelTopAppBar
import com.chrrissoft.marvel.ui.components.NavigationBarColors
import com.chrrissoft.marvel.ui.components.drawer.DrawerSheetColors
import com.chrrissoft.marvel.ui.components.drawer.MarvelDrawer
import com.chrrissoft.marvel.ui.navigation.Screens
import com.chrrissoft.marvel.ui.navigation.Screens.CharsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharsScreen(
    viewModel: CharsViewModel = hiltViewModel(),
    drawerState: DrawerState,
    onOpenDrawer: () -> Unit,
    onNavigate: (Screens) -> Unit,
) {
    val state by viewModel.uiState.collectAsState()

    val containerColor = containerColor
    val contentColor = colorScheme.contentColorFor(containerColor)

    val navigationBarColors = NavigationBarColors(
        contentColor = contentColor,
        containerColor = containerColor
    )

    val drawerContainerColor = colorScheme.surface
    val drawerContentColor = contentColorFor(drawerContainerColor)

    val drawerSheetColors = DrawerSheetColors(
        drawerContainerColor = drawerContainerColor,
        drawerContentColor = drawerContentColor,
    )

    MarvelDrawer(
        item = CharsScreen,
        drawerState = drawerState,
        sheetColors = drawerSheetColors,
        itemColors = NavigationDrawerItemDefaults.colors(),
        onItemsChange = { onNavigate(it) }
    ) {
        MarvelScaffold(
            topAppBar = {
                MarvelTopAppBar(
                    title = stringResource(route_name__chars),
                    colors = TopAppBarDefaults.topAppBarColors()
                ) { onOpenDrawer() }
            },
            navigationBar = {
                MarvelNavigationBar(
                    screenPage = state.screenPage,
                    barColors = navigationBarColors,
                    itemColors = NavigationBarItemDefaults.colors(),
                    onScreenPageChange = { viewModel.changeScreenState(it) }
                )
            }
        ) {
            when (state.screenPage) {
                PREVIEW -> CharsPreviewPage(
                    state.previews,
                    state.previewResState
                ) {
                    viewModel.loadRes()
                }
                INFO -> CharInfo(state.info, state.infoResState)
            }
        }
    }
}


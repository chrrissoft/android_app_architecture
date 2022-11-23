package com.chrrissoft.marvel.ui.comics.ui

import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBarDefaults.containerColor
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.chrrissoft.marvel.R.string.route_name__comics
import com.chrrissoft.marvel.ui.comics.ComicsViewModel
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
fun ComicsScreen(
    viewModel: ComicsViewModel = hiltViewModel(),
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
                    title = stringResource(route_name__comics),
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
                PREVIEW -> ComicsPreviewPage(
                    state.previews,
                    state.previewResState
                ) {
                    viewModel.load()
                }
                INFO -> ComicInfoPage(state.info, state.infoResState)
            }
        }
    }
}


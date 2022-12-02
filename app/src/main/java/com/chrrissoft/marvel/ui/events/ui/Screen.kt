package com.chrrissoft.marvel.ui.events.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.chrrissoft.marvel.R.string.route_name__events
import com.chrrissoft.marvel.ui.common.ScreenPage.INFO
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW
import com.chrrissoft.marvel.ui.components.*
import com.chrrissoft.marvel.ui.components.drawer.MarvelDrawerSheetColors
import com.chrrissoft.marvel.ui.components.drawer.MarvelDrawer
import com.chrrissoft.marvel.ui.components.drawer.MarvelNavigationDrawerItemColors
import com.chrrissoft.marvel.ui.components.scafoold.*
import com.chrrissoft.marvel.ui.events.EventsViewModel
import com.chrrissoft.marvel.ui.navigation.Screens
import com.chrrissoft.marvel.ui.navigation.Screens.EventsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsScreen(
    viewModel: EventsViewModel = hiltViewModel(),
    drawerState: DrawerState,
    onOpenDrawer: () -> Unit,
    onCloseDrawer: () -> Unit,
    onNavigate: (Screens) -> Unit,
) {

    val state by viewModel.uiState.collectAsState()
    val previewListState = rememberLazyListState()

    MarvelDrawer(
        item = EventsScreen,
        drawerState = drawerState,
        onItemsChange = onNavigate,
        onCloseDrawer = onCloseDrawer,
        sheetColors = MarvelDrawerSheetColors.default(),
        itemColors = MarvelNavigationDrawerItemColors.default(),
    ) {
        MarvelScaffold(
            topAppBar = {
                MarvelTopAppBar(
                    title = stringResource(route_name__events),
                    colors = MarvelTopAppBarColors.default()
                ) { onOpenDrawer() }
            },
            navigationBar = {
                MarvelNavigationBar(
                    screenPage = state.screenPage,
                    barColors = MarvelNavBarColors.default(),
                    itemColors = MarvelNavBarItemColors.default(),
                    onScreenPageChange = { viewModel.changeScreenPage(it) }
                )
            }
        ) { padding ->
            when (state.screenPage) {
                PREVIEW -> {
                    EventsPreviewPage(
                        res = state.previews,
                        listState = previewListState,
                        modifier = Modifier.padding(padding),
                        onLoad = { viewModel.loadPreviews() },
                        onGetInfo = { viewModel.loadInfo(it) },
                    )
                }
                INFO -> {
                    EventsInfoPage(
                        res = state.info,
                        modifier = Modifier.padding(padding),
                        onLoadChars = { viewModel.loadChars() },
                        loadComics = { viewModel.loadComics() },
                        onLoadSeries = { viewModel.loadSeries() },
                        onLoadStories = { viewModel.loadStories() },
                    )
                }
            }
        }
    }
}

package com.chrrissoft.marvel.ui.series.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.chrrissoft.marvel.R.string.route_name__series
import com.chrrissoft.marvel.ui.common.ScreenPage.INFO
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW
import com.chrrissoft.marvel.ui.components.*
import com.chrrissoft.marvel.ui.components.drawer.MarvelDrawerSheetColors
import com.chrrissoft.marvel.ui.components.drawer.MarvelDrawer
import com.chrrissoft.marvel.ui.components.drawer.MarvelNavigationDrawerItemColors
import com.chrrissoft.marvel.ui.components.scafoold.*
import com.chrrissoft.marvel.ui.navigation.Screens
import com.chrrissoft.marvel.ui.navigation.Screens.SeriesScreen
import com.chrrissoft.marvel.ui.series.SeriesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeriesScreen(
    viewModel: SeriesViewModel = hiltViewModel(),
    drawerState: DrawerState,
    onOpenDrawer: () -> Unit,
    onCloseDrawer: () -> Unit,
    onNavigate: (Screens) -> Unit,
) {

    val state by viewModel.uiState.collectAsState()
    val previewListState = rememberLazyListState()

    MarvelDrawer(
        item = SeriesScreen,
        drawerState = drawerState,
        onItemsChange = onNavigate,
        onCloseDrawer = onCloseDrawer,
        sheetColors = MarvelDrawerSheetColors.default(),
        itemColors = MarvelNavigationDrawerItemColors.default(),
    ) {
        MarvelScaffold(
            topAppBar = {
                MarvelTopAppBar(
                    title = stringResource(route_name__series),
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
                    SeriesPreviewPage(
                        res = state.previews,
                        listState = previewListState,
                        modifier = Modifier.padding(padding),
                        onLoad = { viewModel.loadPreviews() },
                        onGetInfo = { viewModel.loadInfo(it) },
                    )
                }
                INFO -> {
                    SerieInfoPage(
                        res = state.info,
                        modifier = Modifier.padding(padding),
                        onLoadChars = { viewModel.loadChars() },
                        loadComics = { viewModel.loadComics() },
                        onLoadStories = { viewModel.loadStories() },
                        onLoadEvents = { viewModel.loadEvents() },
                    )
                }
            }
        }
    }
}

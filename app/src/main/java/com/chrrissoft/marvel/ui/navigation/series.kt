package com.chrrissoft.marvel.ui.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chrrissoft.marvel.ui.navigation.Screens.SeriesScreen
import com.chrrissoft.marvel.ui.series.ui.SeriesScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
internal fun NavGraphBuilder.seriesScreen(
    drawerState: DrawerState,
    appScope: CoroutineScope,
    onNavigate: (Screens) -> Unit
) {
    composable(SeriesScreen.route) {
        SeriesScreen(
            drawerState = drawerState,
            onOpenDrawer = { appScope.launch { drawerState.open() } },
            onCloseDrawer = { appScope.launch { drawerState.close() } },
            ) {
            val close = appScope.async { drawerState.close() }
            appScope.launch {
                close.await()
                onNavigate(it)
            }
        }
    }
}

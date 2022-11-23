package com.chrrissoft.marvel.ui.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chrrissoft.marvel.ui.chars.ui.CharsScreen
import com.chrrissoft.marvel.ui.comics.ui.ComicsScreen
import com.chrrissoft.marvel.ui.events.ui.EventsScreen
import com.chrrissoft.marvel.ui.series.ui.SeriesScreen
import com.chrrissoft.marvel.ui.stories.ui.StoriesScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
internal fun NavGraphBuilder.charsScreen(
    drawerState: DrawerState,
    appScope: CoroutineScope,
    onNavigate: (Screens) -> Unit
) {
    composable(Screens.CharsScreen.route) {
        CharsScreen(
            drawerState = drawerState,
            onOpenDrawer = { appScope.launch { drawerState.open() } }
        ) {
            val close = appScope.async { drawerState.close() }
            appScope.launch {
                close.await()
                onNavigate(it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
internal fun NavGraphBuilder.comicsScreen(
    drawerState: DrawerState,
    appScope: CoroutineScope,
    onNavigate: (Screens) -> Unit
) {
    composable(Screens.ComicsScreen.route) {
        ComicsScreen(
            drawerState = drawerState,
            onOpenDrawer = { appScope.launch { drawerState.open() } }
        ) {
            val close = appScope.async { drawerState.close() }
            appScope.launch {
                close.await()
                onNavigate(it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
internal fun NavGraphBuilder.eventsScreen(
    drawerState: DrawerState,
    appScope: CoroutineScope,
    onNavigate: (Screens) -> Unit
) {
    composable(Screens.EventsScreen.route) {
        EventsScreen(
            drawerState = drawerState,
            onOpenDrawer = { appScope.launch { drawerState.open() } }
        ) {
            val close = appScope.async { drawerState.close() }
            appScope.launch {
                close.await()
                onNavigate(it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
internal fun NavGraphBuilder.seriesScreen(
    drawerState: DrawerState,
    appScope: CoroutineScope,
    onNavigate: (Screens) -> Unit
) {
    composable(Screens.SeriesScreen.route) {
        SeriesScreen(
            drawerState = drawerState,
            onOpenDrawer = { appScope.launch { drawerState.open() } }
        ) {
            val close = appScope.async { drawerState.close() }
            appScope.launch {
                close.await()
                onNavigate(it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
internal fun NavGraphBuilder.storiesScreen(
    drawerState: DrawerState,
    appScope: CoroutineScope,
    onNavigate: (Screens) -> Unit
) {
    composable(Screens.StoriesScreen.route) {
        StoriesScreen(
            drawerState = drawerState,
            onOpenDrawer = { appScope.launch { drawerState.open() } }
        ) {
            val close = appScope.async { drawerState.close() }
            appScope.launch {
                close.await()
                onNavigate(it)
            }
        }
    }
}
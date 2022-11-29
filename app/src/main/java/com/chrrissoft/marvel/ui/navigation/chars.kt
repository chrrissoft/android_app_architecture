package com.chrrissoft.marvel.ui.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chrrissoft.marvel.ui.chars.ui.CharsScreen
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


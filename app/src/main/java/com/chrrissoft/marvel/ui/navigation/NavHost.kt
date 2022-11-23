package com.chrrissoft.marvel.ui.navigation

import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.chrrissoft.marvel.ui.navigation.Screens.CharsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(Closed)
    val appScope = rememberCoroutineScope()

    NavHost(navController, CharsScreen.route) {

        charsScreen(drawerState, appScope) {
            navController.navigate(it.route)
        }

        comicsScreen(drawerState, appScope) {
            navController.navigate(it.route)
        }

        eventsScreen(drawerState, appScope) {
            navController.navigate(it.route)
        }

        seriesScreen(drawerState, appScope) {
            navController.navigate(it.route)
        }

        storiesScreen(drawerState, appScope) {
            navController.navigate(it.route)
        }
    }
}

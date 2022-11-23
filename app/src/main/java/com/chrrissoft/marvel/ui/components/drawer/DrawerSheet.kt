package com.chrrissoft.marvel.ui.components.drawer

import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.chrrissoft.marvel.R.string.*
import com.chrrissoft.marvel.ui.navigation.Screens
import com.chrrissoft.marvel.ui.navigation.Screens.*

@ExperimentalMaterial3Api
@Composable
internal fun MarvelDrawerSheet(
    item: Screens,
    sheetColors: DrawerSheetColors,
    itemColors: NavigationDrawerItemColors,
    onItemsChange: (Screens) -> Unit
) {

    val isChars = item == CharsScreen
    val isComics = item == ComicsScreen
    val isSeries = item == SeriesScreen
    val isStories = item == StoriesScreen
    val isEvents = item == EventsScreen

    val chars = stringResource(route_name__chars)
    val comics = stringResource(route_name__comics)
    val series = stringResource(route_name__series)
    val stories = stringResource(route_name__stories)
    val events = stringResource(route_name__events)

    ModalDrawerSheet(
        drawerContainerColor = sheetColors.drawerContainerColor,
        drawerContentColor = sheetColors.drawerContentColor
    ) {
        NavigationDrawerItem(
            label = { DrawerLabel(isChars, chars) },
            selected = isChars,
            onClick = { onItemsChange(CharsScreen) },
            colors = itemColors,
        )

        NavigationDrawerItem(
            label = { DrawerLabel(isComics, comics) },
            selected = isComics,
            colors = itemColors,
            onClick = { onItemsChange(ComicsScreen) }
        )

        NavigationDrawerItem(
            label = { DrawerLabel(isSeries, series) },
            selected = isSeries,
            colors = itemColors,

            onClick = { onItemsChange(SeriesScreen) }
        )

        NavigationDrawerItem(
            label = { DrawerLabel(isStories, stories) },
            selected = isStories,
            colors = itemColors,

            onClick = { onItemsChange(StoriesScreen) }
        )

        NavigationDrawerItem(
            label = { DrawerLabel(isEvents, events) },
            selected = isEvents,
            colors = itemColors,

            onClick = { onItemsChange(EventsScreen) }
        )
    }
}

@Composable
private fun DrawerLabel(
    selected: Boolean, text: String
) {
    if (selected) Text(text = text, color = colorScheme.onPrimary)
    else Text(text = text)
}

data class DrawerSheetColors(
    val drawerContainerColor: Color,
    val drawerContentColor: Color,
)


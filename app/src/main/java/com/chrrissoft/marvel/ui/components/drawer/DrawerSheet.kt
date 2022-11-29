package com.chrrissoft.marvel.ui.components.drawer

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chrrissoft.marvel.R.string.*
import com.chrrissoft.marvel.ui.navigation.Screens
import com.chrrissoft.marvel.ui.navigation.Screens.*

@ExperimentalMaterial3Api
@Composable
internal fun MarvelDrawerSheet(
    item: Screens,
    onCloseDrawer: () -> Unit,
    sheetColors: MarvelDrawerSheetColors = MarvelDrawerSheetColors.default(),
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

    val charsIcon = if (item == CharsScreen) Filled.Build else Outlined.Build
    val comicsIcon = if (item == ComicsScreen) Filled.Build else Outlined.Build
    val seriesIcon = if (item == SeriesScreen) Filled.Build else Outlined.Build
    val storiesIcon = if (item == StoriesScreen) Filled.Build else Outlined.Build
    val eventsIcon = if (item == EventsScreen) Filled.Build else Outlined.Build

    ModalDrawerSheet(
        drawerContainerColor = sheetColors.drawerContainerColor,
        drawerContentColor = sheetColors.drawerContentColor
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 18.dp),
        ) {
            DrawerSheetTitle(sheetColors.title)
            IconButton(onClick = { onCloseDrawer() }, modifier = Modifier.align(CenterEnd)) {
                Icon(Outlined.Menu, contentDescription = null, tint = sheetColors.closeIcon)
            }
        }

        NavigationDrawerItem(
            label = { DrawerLabel(isChars, chars) },
            selected = isChars,
            icon = { Icon(charsIcon, contentDescription = null) },
            onClick = { onItemsChange(CharsScreen) },
            colors = itemColors,
        )

        NavigationDrawerItem(
            selected = isComics,
            colors = itemColors,
            icon = { Icon(comicsIcon, contentDescription = null) },
            label = { DrawerLabel(isComics, comics) },
            onClick = { onItemsChange(ComicsScreen) }
        )

        NavigationDrawerItem(
            selected = isSeries,
            colors = itemColors,
            icon = { Icon(seriesIcon, contentDescription = null) },
            label = { DrawerLabel(isSeries, series) },
            onClick = { onItemsChange(SeriesScreen) }
        )

        NavigationDrawerItem(
            colors = itemColors,
            selected = isStories,
            label = { DrawerLabel(isStories, stories) },
            onClick = { onItemsChange(StoriesScreen) },
            icon = { Icon(storiesIcon, contentDescription = null) },
        )

        NavigationDrawerItem(
            selected = isEvents,
            colors = itemColors,
            label = { DrawerLabel(isEvents, events) },
            onClick = { onItemsChange(EventsScreen) },
            icon = { Icon(eventsIcon, contentDescription = null) },
        )
    }
}

@Composable
private fun BoxScope.DrawerSheetTitle(
    color: Color,
    text: String = stringResource(drawer_sheet_title),
) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        style = typography.titleLarge.copy(letterSpacing = 3.sp, color = color),
        modifier = Modifier.align(Center),
    )
}

@Composable
private fun DrawerLabel(
    selected: Boolean, text: String
) {
    if (selected) Text(text = text, fontWeight = FontWeight.Bold)
    else Text(text = text)
}

data class MarvelDrawerSheetColors(
    val title: Color,
    val closeIcon: Color,
    val drawerContentColor: Color,
    val drawerContainerColor: Color,
) {
    companion object {
        @Composable
        fun default(): MarvelDrawerSheetColors {

            val drawerContainerColor = colorScheme.primaryContainer
            val drawerContentColor = contentColorFor(drawerContainerColor)

            return MarvelDrawerSheetColors(
                drawerContainerColor = drawerContainerColor,
                drawerContentColor = drawerContentColor,
                title = colorScheme.onPrimaryContainer,
                closeIcon = colorScheme.onPrimaryContainer,
            )
        }
    }
}

data class MarvelNavigationDrawerItemColors(
    val selectedContainerColor: Color,
    val unselectedContainerColor: Color,
    val selectedIconColor: Color,
    val unselectedIconColor: Color,
    val selectedTextColor: Color,
    val unselectedTextColor: Color,
    val selectedBadgeColor: Color,
    val unselectedBadgeColor: Color,
) {
    companion object {
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun default(): NavigationDrawerItemColors {
            return NavigationDrawerItemDefaults.colors(
                selectedContainerColor = colorScheme.primary,
                unselectedContainerColor = colorScheme.primaryContainer,
                selectedIconColor = colorScheme.onPrimary,
                unselectedIconColor = colorScheme.onPrimaryContainer,
                selectedTextColor = colorScheme.onPrimary,
                unselectedTextColor = colorScheme.onPrimaryContainer,
                selectedBadgeColor = colorScheme.onPrimary,
                unselectedBadgeColor = colorScheme.onPrimaryContainer,
            )
        }
    }
}
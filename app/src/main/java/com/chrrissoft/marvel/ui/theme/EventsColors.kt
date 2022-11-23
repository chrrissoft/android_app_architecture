package com.chrrissoft.marvel.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


object EventsColor {

    val eventsLight_surfaceTint = Color(0xFF6750A4)
    val eventsLight_surfaceTintColor = Color(0xFF6750A4)
    val eventsLight_onErrorContainer = Color(0xFF410E0B)
    val eventsLight_onError = Color(0xFFFFFFFF)
    val eventsLight_errorContainer = Color(0xFFF9DEDC)
    val eventsLight_onTertiaryContainer = Color(0xFF31111D)
    val eventsLight_onTertiary = Color(0xFFFFFFFF)
    val eventsLight_tertiaryContainer = Color(0xFFFFD8E4)
    val eventsLight_tertiary = Color(0xFF7D5260)
    val eventsLight_shadow = Color(0xFF000000)
    val eventsLight_error = Color(0xFFB3261E)
    val eventsLight_outline = Color(0xFF79747E)
    val eventsLight_onBackground = Color(0xFF1C1B1F)
    val eventsLight_background = Color(0xFFFFFBFE)
    val eventsLight_inverseOnSurface = Color(0xFFF4EFF4)
    val eventsLight_inverseSurface = Color(0xFF313033)
    val eventsLight_onSurfaceVariant = Color(0xFF49454F)
    val eventsLight_onSurface = Color(0xFF1C1B1F)
    val eventsLight_surfaceVariant = Color(0xFFE7E0EC)
    val eventsLight_surface = Color(0xFFFFFBFE)
    val eventsLight_onSecondaryContainer = Color(0xFF1D192B)
    val eventsLight_onSecondary = Color(0xFFFFFFFF)
    val eventsLight_secondaryContainer = Color(0xFFE8DEF8)
    val eventsLight_secondary = Color(0xFF625B71)
    val eventsLight_inversePrimary = Color(0xFFD0BCFF)
    val eventsLight_onPrimaryContainer = Color(0xFF21005D)
    val eventsLight_onPrimary = Color(0xFFFFFFFF)
    val eventsLight_primaryContainer = Color(0xFFEADDFF)
    val eventsLight_primary = Color(0xFF6750A4)

    val eventsDark_surfaceTint = Color(0xFFD0BCFF)
    val eventsDark_surfaceTintColor = Color(0xFFD0BCFF)
    val eventsDark_onErrorContainer = Color(0xFFF2B8B5)
    val eventsDark_onError = Color(0xFF601410)
    val eventsDark_errorContainer = Color(0xFF8C1D18)
    val eventsDark_onTertiaryContainer = Color(0xFFFFD8E4)
    val eventsDark_onTertiary = Color(0xFF492532)
    val eventsDark_tertiaryContainer = Color(0xFF633B48)
    val eventsDark_tertiary = Color(0xFFEFB8C8)
    val eventsDark_shadow = Color(0xFF000000)
    val eventsDark_error = Color(0xFFF2B8B5)
    val eventsDark_outline = Color(0xFF938F99)
    val eventsDark_onBackground = Color(0xFFE6E1E5)
    val eventsDark_background = Color(0xFF1C1B1F)
    val eventsDark_inverseOnSurface = Color(0xFF313033)
    val eventsDark_inverseSurface = Color(0xFFE6E1E5)
    val eventsDark_onSurfaceVariant = Color(0xFFCAC4D0)
    val eventsDark_onSurface = Color(0xFFE6E1E5)
    val eventsDark_surfaceVariant = Color(0xFF49454F)
    val eventsDark_surface = Color(0xFF1C1B1F)
    val eventsDark_onSecondaryContainer = Color(0xFFE8DEF8)
    val eventsDark_onSecondary = Color(0xFF332D41)
    val eventsDark_secondaryContainer = Color(0xFF4A4458)
    val eventsDark_secondary = Color(0xFFCCC2DC)
    val eventsDark_inversePrimary = Color(0xFF6750A4)
    val eventsDark_onPrimaryContainer = Color(0xFFEADDFF)
    val eventsDark_onPrimary = Color(0xFF381E72)
    val eventsDark_primaryContainer = Color(0xFF4F378B)
    val eventsDark_primary = Color(0xFFD0BCFF)
}

val ColorScheme.eventsSurfaceTint: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_surfaceTint
        else EventsColor.eventsDark_surfaceTint

val ColorScheme.eventsSurfaceTintColor: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_surfaceTintColor
        else EventsColor.eventsDark_surfaceTintColor

val ColorScheme.eventsOnErrorContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_onErrorContainer
        else EventsColor.eventsDark_onErrorContainer

val ColorScheme.eventsOnError: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_onError
        else EventsColor.eventsDark_onError

val ColorScheme.eventsErrorContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_errorContainer
        else EventsColor.eventsDark_errorContainer

val ColorScheme.eventsOnTertiaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_onTertiaryContainer
        else EventsColor.eventsDark_onTertiaryContainer

val ColorScheme.eventsOnTertiary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_onTertiary
        else EventsColor.eventsDark_onTertiary

val ColorScheme.eventsTertiaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_tertiaryContainer
        else EventsColor.eventsDark_tertiaryContainer

val ColorScheme.eventsTertiary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_tertiary
        else EventsColor.eventsDark_tertiary

val ColorScheme.eventsShadow: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_shadow
        else EventsColor.eventsDark_shadow

val ColorScheme.eventsError: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_error
        else EventsColor.eventsDark_error

val ColorScheme.eventsOutline: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_outline
        else EventsColor.eventsDark_outline

val ColorScheme.eventsOnBackground: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_onBackground
        else EventsColor.eventsDark_onBackground

val ColorScheme.eventsBackground: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_background
        else EventsColor.eventsDark_background

val ColorScheme.eventsInverseOnSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_inverseOnSurface
        else EventsColor.eventsDark_inverseOnSurface

val ColorScheme.eventsInverseSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_inverseSurface
        else EventsColor.eventsDark_inverseSurface

val ColorScheme.eventsOnSurfaceVariant: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_onSurfaceVariant
        else EventsColor.eventsDark_onSurfaceVariant

val ColorScheme.eventsOnSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_onSurface
        else EventsColor.eventsDark_onSurface

val ColorScheme.eventsSurfaceVariant: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_surfaceVariant
        else EventsColor.eventsDark_surfaceVariant

val ColorScheme.eventsSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_surface
        else EventsColor.eventsDark_surface

val ColorScheme.eventsOnSecondaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_onSecondaryContainer
        else EventsColor.eventsDark_onSecondaryContainer

val ColorScheme.eventsOnSecondary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_onSecondary
        else EventsColor.eventsDark_onSecondary

val ColorScheme.eventsSecondaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_secondaryContainer
        else EventsColor.eventsDark_secondaryContainer

val ColorScheme.eventsSecondary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_secondary
        else EventsColor.eventsDark_secondary

val ColorScheme.eventsInversePrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_inversePrimary
        else EventsColor.eventsDark_inversePrimary

val ColorScheme.eventsOnPrimaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_onPrimaryContainer
        else EventsColor.eventsDark_onPrimaryContainer

val ColorScheme.eventsOnPrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_onPrimary
        else EventsColor.eventsDark_onPrimary

val ColorScheme.eventsPrimaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_primaryContainer
        else EventsColor.eventsDark_primaryContainer

val ColorScheme.eventsPrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) EventsColor.eventsLight_primary
        else EventsColor.eventsDark_primary

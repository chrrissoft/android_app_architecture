package com.chrrissoft.marvel.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


object SeriesColor {

    val seriesLight_surfaceTint = Color(0xFF6750A4)
    val seriesLight_surfaceTintColor = Color(0xFF6750A4)
    val seriesLight_onErrorContainer = Color(0xFF410E0B)
    val seriesLight_onError = Color(0xFFFFFFFF)
    val seriesLight_errorContainer = Color(0xFFF9DEDC)
    val seriesLight_onTertiaryContainer = Color(0xFF31111D)
    val seriesLight_onTertiary = Color(0xFFFFFFFF)
    val seriesLight_tertiaryContainer = Color(0xFFFFD8E4)
    val seriesLight_tertiary = Color(0xFF7D5260)
    val seriesLight_shadow = Color(0xFF000000)
    val seriesLight_error = Color(0xFFB3261E)
    val seriesLight_outline = Color(0xFF79747E)
    val seriesLight_onBackground = Color(0xFF1C1B1F)
    val seriesLight_background = Color(0xFFFFFBFE)
    val seriesLight_inverseOnSurface = Color(0xFFF4EFF4)
    val seriesLight_inverseSurface = Color(0xFF313033)
    val seriesLight_onSurfaceVariant = Color(0xFF49454F)
    val seriesLight_onSurface = Color(0xFF1C1B1F)
    val seriesLight_surfaceVariant = Color(0xFFE7E0EC)
    val seriesLight_surface = Color(0xFFFFFBFE)
    val seriesLight_onSecondaryContainer = Color(0xFF1D192B)
    val seriesLight_onSecondary = Color(0xFFFFFFFF)
    val seriesLight_secondaryContainer = Color(0xFFE8DEF8)
    val seriesLight_secondary = Color(0xFF625B71)
    val seriesLight_inversePrimary = Color(0xFFD0BCFF)
    val seriesLight_onPrimaryContainer = Color(0xFF21005D)
    val seriesLight_onPrimary = Color(0xFFFFFFFF)
    val seriesLight_primaryContainer = Color(0xFFEADDFF)
    val seriesLight_primary = Color(0xFF6750A4)

    val seriesDark_surfaceTint = Color(0xFFD0BCFF)
    val seriesDark_surfaceTintColor = Color(0xFFD0BCFF)
    val seriesDark_onErrorContainer = Color(0xFFF2B8B5)
    val seriesDark_onError = Color(0xFF601410)
    val seriesDark_errorContainer = Color(0xFF8C1D18)
    val seriesDark_onTertiaryContainer = Color(0xFFFFD8E4)
    val seriesDark_onTertiary = Color(0xFF492532)
    val seriesDark_tertiaryContainer = Color(0xFF633B48)
    val seriesDark_tertiary = Color(0xFFEFB8C8)
    val seriesDark_shadow = Color(0xFF000000)
    val seriesDark_error = Color(0xFFF2B8B5)
    val seriesDark_outline = Color(0xFF938F99)
    val seriesDark_onBackground = Color(0xFFE6E1E5)
    val seriesDark_background = Color(0xFF1C1B1F)
    val seriesDark_inverseOnSurface = Color(0xFF313033)
    val seriesDark_inverseSurface = Color(0xFFE6E1E5)
    val seriesDark_onSurfaceVariant = Color(0xFFCAC4D0)
    val seriesDark_onSurface = Color(0xFFE6E1E5)
    val seriesDark_surfaceVariant = Color(0xFF49454F)
    val seriesDark_surface = Color(0xFF1C1B1F)
    val seriesDark_onSecondaryContainer = Color(0xFFE8DEF8)
    val seriesDark_onSecondary = Color(0xFF332D41)
    val seriesDark_secondaryContainer = Color(0xFF4A4458)
    val seriesDark_secondary = Color(0xFFCCC2DC)
    val seriesDark_inversePrimary = Color(0xFF6750A4)
    val seriesDark_onPrimaryContainer = Color(0xFFEADDFF)
    val seriesDark_onPrimary = Color(0xFF381E72)
    val seriesDark_primaryContainer = Color(0xFF4F378B)
    val seriesDark_primary = Color(0xFFD0BCFF)
}

val ColorScheme.seriesSurfaceTint: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_surfaceTint
        else SeriesColor.seriesDark_surfaceTint

val ColorScheme.seriesSurfaceTintColor: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_surfaceTintColor
        else SeriesColor.seriesDark_surfaceTintColor

val ColorScheme.seriesOnErrorContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_onErrorContainer
        else SeriesColor.seriesDark_onErrorContainer

val ColorScheme.seriesOnError: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_onError
        else SeriesColor.seriesDark_onError

val ColorScheme.seriesErrorContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_errorContainer
        else SeriesColor.seriesDark_errorContainer

val ColorScheme.seriesOnTertiaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_onTertiaryContainer
        else SeriesColor.seriesDark_onTertiaryContainer

val ColorScheme.seriesOnTertiary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_onTertiary
        else SeriesColor.seriesDark_onTertiary

val ColorScheme.seriesTertiaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_tertiaryContainer
        else SeriesColor.seriesDark_tertiaryContainer

val ColorScheme.seriesTertiary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_tertiary
        else SeriesColor.seriesDark_tertiary

val ColorScheme.seriesShadow: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_shadow
        else SeriesColor.seriesDark_shadow

val ColorScheme.seriesError: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_error
        else SeriesColor.seriesDark_error

val ColorScheme.seriesOutline: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_outline
        else SeriesColor.seriesDark_outline

val ColorScheme.seriesOnBackground: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_onBackground
        else SeriesColor.seriesDark_onBackground

val ColorScheme.seriesBackground: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_background
        else SeriesColor.seriesDark_background

val ColorScheme.seriesInverseOnSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_inverseOnSurface
        else SeriesColor.seriesDark_inverseOnSurface

val ColorScheme.seriesInverseSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_inverseSurface
        else SeriesColor.seriesDark_inverseSurface

val ColorScheme.seriesOnSurfaceVariant: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_onSurfaceVariant
        else SeriesColor.seriesDark_onSurfaceVariant

val ColorScheme.seriesOnSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_onSurface
        else SeriesColor.seriesDark_onSurface

val ColorScheme.seriesSurfaceVariant: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_surfaceVariant
        else SeriesColor.seriesDark_surfaceVariant

val ColorScheme.seriesSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_surface
        else SeriesColor.seriesDark_surface

val ColorScheme.seriesOnSecondaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_onSecondaryContainer
        else SeriesColor.seriesDark_onSecondaryContainer

val ColorScheme.seriesOnSecondary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_onSecondary
        else SeriesColor.seriesDark_onSecondary

val ColorScheme.seriesSecondaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_secondaryContainer
        else SeriesColor.seriesDark_secondaryContainer

val ColorScheme.seriesSecondary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_secondary
        else SeriesColor.seriesDark_secondary

val ColorScheme.seriesInversePrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_inversePrimary
        else SeriesColor.seriesDark_inversePrimary

val ColorScheme.seriesOnPrimaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_onPrimaryContainer
        else SeriesColor.seriesDark_onPrimaryContainer

val ColorScheme.seriesOnPrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_onPrimary
        else SeriesColor.seriesDark_onPrimary

val ColorScheme.seriesPrimaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_primaryContainer
        else SeriesColor.seriesDark_primaryContainer

val ColorScheme.seriesPrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) SeriesColor.seriesLight_primary
        else SeriesColor.seriesDark_primary

package com.chrrissoft.marvel.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


object StoriesColors {

    val storiesLight_surfaceTint = Color(0xFF6750A4)
    val storiesLight_surfaceTintColor = Color(0xFF6750A4)
    val storiesLight_onErrorContainer = Color(0xFF410E0B)
    val storiesLight_onError = Color(0xFFFFFFFF)
    val storiesLight_errorContainer = Color(0xFFF9DEDC)
    val storiesLight_onTertiaryContainer = Color(0xFF31111D)
    val storiesLight_onTertiary = Color(0xFFFFFFFF)
    val storiesLight_tertiaryContainer = Color(0xFFFFD8E4)
    val storiesLight_tertiary = Color(0xFF7D5260)
    val storiesLight_shadow = Color(0xFF000000)
    val storiesLight_error = Color(0xFFB3261E)
    val storiesLight_outline = Color(0xFF79747E)
    val storiesLight_onBackground = Color(0xFF1C1B1F)
    val storiesLight_background = Color(0xFFFFFBFE)
    val storiesLight_inverseOnSurface = Color(0xFFF4EFF4)
    val storiesLight_inverseSurface = Color(0xFF313033)
    val storiesLight_onSurfaceVariant = Color(0xFF49454F)
    val storiesLight_onSurface = Color(0xFF1C1B1F)
    val storiesLight_surfaceVariant = Color(0xFFE7E0EC)
    val storiesLight_surface = Color(0xFFFFFBFE)
    val storiesLight_onSecondaryContainer = Color(0xFF1D192B)
    val storiesLight_onSecondary = Color(0xFFFFFFFF)
    val storiesLight_secondaryContainer = Color(0xFFE8DEF8)
    val storiesLight_secondary = Color(0xFF625B71)
    val storiesLight_inversePrimary = Color(0xFFD0BCFF)
    val storiesLight_onPrimaryContainer = Color(0xFF21005D)
    val storiesLight_onPrimary = Color(0xFFFFFFFF)
    val storiesLight_primaryContainer = Color(0xFFEADDFF)
    val storiesLight_primary = Color(0xFF6750A4)

    val storiesDark_surfaceTint = Color(0xFFD0BCFF)
    val storiesDark_surfaceTintColor = Color(0xFFD0BCFF)
    val storiesDark_onErrorContainer = Color(0xFFF2B8B5)
    val storiesDark_onError = Color(0xFF601410)
    val storiesDark_errorContainer = Color(0xFF8C1D18)
    val storiesDark_onTertiaryContainer = Color(0xFFFFD8E4)
    val storiesDark_onTertiary = Color(0xFF492532)
    val storiesDark_tertiaryContainer = Color(0xFF633B48)
    val storiesDark_tertiary = Color(0xFFEFB8C8)
    val storiesDark_shadow = Color(0xFF000000)
    val storiesDark_error = Color(0xFFF2B8B5)
    val storiesDark_outline = Color(0xFF938F99)
    val storiesDark_onBackground = Color(0xFFE6E1E5)
    val storiesDark_background = Color(0xFF1C1B1F)
    val storiesDark_inverseOnSurface = Color(0xFF313033)
    val storiesDark_inverseSurface = Color(0xFFE6E1E5)
    val storiesDark_onSurfaceVariant = Color(0xFFCAC4D0)
    val storiesDark_onSurface = Color(0xFFE6E1E5)
    val storiesDark_surfaceVariant = Color(0xFF49454F)
    val storiesDark_surface = Color(0xFF1C1B1F)
    val storiesDark_onSecondaryContainer = Color(0xFFE8DEF8)
    val storiesDark_onSecondary = Color(0xFF332D41)
    val storiesDark_secondaryContainer = Color(0xFF4A4458)
    val storiesDark_secondary = Color(0xFFCCC2DC)
    val storiesDark_inversePrimary = Color(0xFF6750A4)
    val storiesDark_onPrimaryContainer = Color(0xFFEADDFF)
    val storiesDark_onPrimary = Color(0xFF381E72)
    val storiesDark_primaryContainer = Color(0xFF4F378B)
    val storiesDark_primary = Color(0xFFD0BCFF)
}

val ColorScheme.storiesSurfaceTint: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_surfaceTint
        else StoriesColors.storiesDark_surfaceTint

val ColorScheme.storiesSurfaceTintColor: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_surfaceTintColor
        else StoriesColors.storiesDark_surfaceTintColor

val ColorScheme.storiesOnErrorContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_onErrorContainer
        else StoriesColors.storiesDark_onErrorContainer

val ColorScheme.storiesOnError: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_onError
        else StoriesColors.storiesDark_onError

val ColorScheme.storiesErrorContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_errorContainer
        else StoriesColors.storiesDark_errorContainer

val ColorScheme.storiesOnTertiaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_onTertiaryContainer
        else StoriesColors.storiesDark_onTertiaryContainer

val ColorScheme.storiesOnTertiary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_onTertiary
        else StoriesColors.storiesDark_onTertiary

val ColorScheme.storiesTertiaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_tertiaryContainer
        else StoriesColors.storiesDark_tertiaryContainer

val ColorScheme.storiesTertiary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_tertiary
        else StoriesColors.storiesDark_tertiary

val ColorScheme.storiesShadow: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_shadow
        else StoriesColors.storiesDark_shadow

val ColorScheme.storiesError: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_error
        else StoriesColors.storiesDark_error

val ColorScheme.storiesOutline: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_outline
        else StoriesColors.storiesDark_outline

val ColorScheme.storiesOnBackground: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_onBackground
        else StoriesColors.storiesDark_onBackground

val ColorScheme.storiesBackground: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_background
        else StoriesColors.storiesDark_background

val ColorScheme.storiesInverseOnSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_inverseOnSurface
        else StoriesColors.storiesDark_inverseOnSurface

val ColorScheme.storiesInverseSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_inverseSurface
        else StoriesColors.storiesDark_inverseSurface

val ColorScheme.storiesOnSurfaceVariant: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_onSurfaceVariant
        else StoriesColors.storiesDark_onSurfaceVariant

val ColorScheme.storiesOnSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_onSurface
        else StoriesColors.storiesDark_onSurface

val ColorScheme.storiesSurfaceVariant: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_surfaceVariant
        else StoriesColors.storiesDark_surfaceVariant

val ColorScheme.storiesSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_surface
        else StoriesColors.storiesDark_surface

val ColorScheme.storiesOnSecondaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_onSecondaryContainer
        else StoriesColors.storiesDark_onSecondaryContainer

val ColorScheme.storiesOnSecondary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_onSecondary
        else StoriesColors.storiesDark_onSecondary

val ColorScheme.storiesSecondaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_secondaryContainer
        else StoriesColors.storiesDark_secondaryContainer

val ColorScheme.storiesSecondary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_secondary
        else StoriesColors.storiesDark_secondary

val ColorScheme.storiesInversePrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_inversePrimary
        else StoriesColors.storiesDark_inversePrimary

val ColorScheme.storiesOnPrimaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_onPrimaryContainer
        else StoriesColors.storiesDark_onPrimaryContainer

val ColorScheme.storiesOnPrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_onPrimary
        else StoriesColors.storiesDark_onPrimary

val ColorScheme.storiesPrimaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_primaryContainer
        else StoriesColors.storiesDark_primaryContainer

val ColorScheme.storiesPrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) StoriesColors.storiesLight_primary
        else StoriesColors.storiesDark_primary

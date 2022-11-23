package com.chrrissoft.marvel.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


object ComicsColors {

    val comicsLight_surfaceTint = Color(0xFF6750A4)
    val comicsLight_surfaceTintColor = Color(0xFF6750A4)
    val comicsLight_onErrorContainer = Color(0xFF410E0B)
    val comicsLight_onError = Color(0xFFFFFFFF)
    val comicsLight_errorContainer = Color(0xFFF9DEDC)
    val comicsLight_onTertiaryContainer = Color(0xFF31111D)
    val comicsLight_onTertiary = Color(0xFFFFFFFF)
    val comicsLight_tertiaryContainer = Color(0xFFFFD8E4)
    val comicsLight_tertiary = Color(0xFF7D5260)
    val comicsLight_shadow = Color(0xFF000000)
    val comicsLight_error = Color(0xFFB3261E)
    val comicsLight_outline = Color(0xFF79747E)
    val comicsLight_onBackground = Color(0xFF1C1B1F)
    val comicsLight_background = Color(0xFFFFFBFE)
    val comicsLight_inverseOnSurface = Color(0xFFF4EFF4)
    val comicsLight_inverseSurface = Color(0xFF313033)
    val comicsLight_onSurfaceVariant = Color(0xFF49454F)
    val comicsLight_onSurface = Color(0xFF1C1B1F)
    val comicsLight_surfaceVariant = Color(0xFFE7E0EC)
    val comicsLight_surface = Color(0xFFFFFBFE)
    val comicsLight_onSecondaryContainer = Color(0xFF1D192B)
    val comicsLight_onSecondary = Color(0xFFFFFFFF)
    val comicsLight_secondaryContainer = Color(0xFFE8DEF8)
    val comicsLight_secondary = Color(0xFF625B71)
    val comicsLight_inversePrimary = Color(0xFFD0BCFF)
    val comicsLight_onPrimaryContainer = Color(0xFF21005D)
    val comicsLight_onPrimary = Color(0xFFFFFFFF)
    val comicsLight_primaryContainer = Color(0xFFEADDFF)
    val comicsLight_primary = Color(0xFF6750A4)

    val comicsDark_surfaceTint = Color(0xFFD0BCFF)
    val comicsDark_surfaceTintColor = Color(0xFFD0BCFF)
    val comicsDark_onErrorContainer = Color(0xFFF2B8B5)
    val comicsDark_onError = Color(0xFF601410)
    val comicsDark_errorContainer = Color(0xFF8C1D18)
    val comicsDark_onTertiaryContainer = Color(0xFFFFD8E4)
    val comicsDark_onTertiary = Color(0xFF492532)
    val comicsDark_tertiaryContainer = Color(0xFF633B48)
    val comicsDark_tertiary = Color(0xFFEFB8C8)
    val comicsDark_shadow = Color(0xFF000000)
    val comicsDark_error = Color(0xFFF2B8B5)
    val comicsDark_outline = Color(0xFF938F99)
    val comicsDark_onBackground = Color(0xFFE6E1E5)
    val comicsDark_background = Color(0xFF1C1B1F)
    val comicsDark_inverseOnSurface = Color(0xFF313033)
    val comicsDark_inverseSurface = Color(0xFFE6E1E5)
    val comicsDark_onSurfaceVariant = Color(0xFFCAC4D0)
    val comicsDark_onSurface = Color(0xFFE6E1E5)
    val comicsDark_surfaceVariant = Color(0xFF49454F)
    val comicsDark_surface = Color(0xFF1C1B1F)
    val comicsDark_onSecondaryContainer = Color(0xFFE8DEF8)
    val comicsDark_onSecondary = Color(0xFF332D41)
    val comicsDark_secondaryContainer = Color(0xFF4A4458)
    val comicsDark_secondary = Color(0xFFCCC2DC)
    val comicsDark_inversePrimary = Color(0xFF6750A4)
    val comicsDark_onPrimaryContainer = Color(0xFFEADDFF)
    val comicsDark_onPrimary = Color(0xFF381E72)
    val comicsDark_primaryContainer = Color(0xFF4F378B)
    val comicsDark_primary = Color(0xFFD0BCFF)
}

val ColorScheme.comicsSurfaceTint: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_surfaceTint
        else ComicsColors.comicsDark_surfaceTint

val ColorScheme.comicsSurfaceTintColor: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_surfaceTintColor
        else ComicsColors.comicsDark_surfaceTintColor

val ColorScheme.comicsOnErrorContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_onErrorContainer
        else ComicsColors.comicsDark_onErrorContainer

val ColorScheme.comicsOnError: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_onError
        else ComicsColors.comicsDark_onError

val ColorScheme.comicsErrorContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_errorContainer
        else ComicsColors.comicsDark_errorContainer

val ColorScheme.comicsOnTertiaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_onTertiaryContainer
        else ComicsColors.comicsDark_onTertiaryContainer

val ColorScheme.comicsOnTertiary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_onTertiary
        else ComicsColors.comicsDark_onTertiary

val ColorScheme.comicsTertiaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_tertiaryContainer
        else ComicsColors.comicsDark_tertiaryContainer

val ColorScheme.comicsTertiary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_tertiary
        else ComicsColors.comicsDark_tertiary

val ColorScheme.comicsShadow: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_shadow
        else ComicsColors.comicsDark_shadow

val ColorScheme.comicsError: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_error
    else ComicsColors.comicsDark_error

val ColorScheme.comicsOutline: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_outline
        else ComicsColors.comicsDark_outline

val ColorScheme.comicsOnBackground: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_onBackground
        else ComicsColors.comicsDark_onBackground

val ColorScheme.comicsBackground: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_background
        else ComicsColors.comicsDark_background

val ColorScheme.comicsInverseOnSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_inverseOnSurface
        else ComicsColors.comicsDark_inverseOnSurface

val ColorScheme.comicsInverseSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_inverseSurface
        else ComicsColors.comicsDark_inverseSurface

val ColorScheme.comicsOnSurfaceVariant: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_onSurfaceVariant
        else ComicsColors.comicsDark_onSurfaceVariant

val ColorScheme.comicsOnSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_onSurface
        else ComicsColors.comicsDark_onSurface

val ColorScheme.comicsSurfaceVariant: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_surfaceVariant
        else ComicsColors.comicsDark_surfaceVariant

val ColorScheme.comicsSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_surface
        else ComicsColors.comicsDark_surface

val ColorScheme.comicsOnSecondaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_onSecondaryContainer
        else ComicsColors.comicsDark_onSecondaryContainer

val ColorScheme.comicsOnSecondary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_onSecondary
        else ComicsColors.comicsDark_onSecondary

val ColorScheme.comicsSecondaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_secondaryContainer
        else ComicsColors.comicsDark_secondaryContainer

val ColorScheme.comicsSecondary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_secondary
        else ComicsColors.comicsDark_secondary

val ColorScheme.comicsInversePrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_inversePrimary
        else ComicsColors.comicsDark_inversePrimary

val ColorScheme.comicsOnPrimaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_onPrimaryContainer
        else ComicsColors.comicsDark_onPrimaryContainer

val ColorScheme.comicsOnPrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_onPrimary
        else ComicsColors.comicsDark_onPrimary

val ColorScheme.comicsPrimaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_primaryContainer
        else ComicsColors.comicsDark_primaryContainer

val ColorScheme.comicsPrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) ComicsColors.comicsLight_primary
        else ComicsColors.comicsDark_primary

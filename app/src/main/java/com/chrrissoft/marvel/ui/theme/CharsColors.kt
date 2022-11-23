package com.chrrissoft.marvel.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


object CharsColors {

    val charsLight_surfaceTint = Color(0xFF6750A4)
    val charsLight_surfaceTintColor = Color(0xFF6750A4)
    val charsLight_onErrorContainer = Color(0xFF410E0B)
    val charsLight_onError = Color(0xFFFFFFFF)
    val charsLight_errorContainer = Color(0xFFF9DEDC)
    val charsLight_onTertiaryContainer = Color(0xFF31111D)
    val charsLight_onTertiary = Color(0xFFFFFFFF)
    val charsLight_tertiaryContainer = Color(0xFFFFD8E4)
    val charsLight_tertiary = Color(0xFF7D5260)
    val charsLight_shadow = Color(0xFF000000)
    val charsLight_error = Color(0xFFB3261E)
    val charsLight_outline = Color(0xFF79747E)
    val charsLight_onBackground = Color(0xFF1C1B1F)
    val charsLight_background = Color(0xFFFFFBFE)
    val charsLight_inverseOnSurface = Color(0xFFF4EFF4)
    val charsLight_inverseSurface = Color(0xFF313033)
    val charsLight_onSurfaceVariant = Color(0xFF49454F)
    val charsLight_onSurface = Color(0xFF1C1B1F)
    val charsLight_surfaceVariant = Color(0xFFE7E0EC)
    val charsLight_surface = Color(0xFFFFFBFE)
    val charsLight_onSecondaryContainer = Color(0xFF1D192B)
    val charsLight_onSecondary = Color(0xFFFFFFFF)
    val charsLight_secondaryContainer = Color(0xFFE8DEF8)
    val charsLight_secondary = Color(0xFF625B71)
    val charsLight_inversePrimary = Color(0xFFD0BCFF)
    val charsLight_onPrimaryContainer = Color(0xFF21005D)
    val charsLight_onPrimary = Color(0xFFFFFFFF)
    val charsLight_primaryContainer = Color(0xFFEADDFF)
    val charsLight_primary = Color(0xFF6750A4)

    val charsDark_surfaceTint = Color(0xFFD0BCFF)
    val charsDark_surfaceTintColor = Color(0xFFD0BCFF)
    val charsDark_onErrorContainer = Color(0xFFF2B8B5)
    val charsDark_onError = Color(0xFF601410)
    val charsDark_errorContainer = Color(0xFF8C1D18)
    val charsDark_onTertiaryContainer = Color(0xFFFFD8E4)
    val charsDark_onTertiary = Color(0xFF492532)
    val charsDark_tertiaryContainer = Color(0xFF633B48)
    val charsDark_tertiary = Color(0xFFEFB8C8)
    val charsDark_shadow = Color(0xFF000000)
    val charsDark_error = Color(0xFFF2B8B5)
    val charsDark_outline = Color(0xFF938F99)
    val charsDark_onBackground = Color(0xFFE6E1E5)
    val charsDark_background = Color(0xFF1C1B1F)
    val charsDark_inverseOnSurface = Color(0xFF313033)
    val charsDark_inverseSurface = Color(0xFFE6E1E5)
    val charsDark_onSurfaceVariant = Color(0xFFCAC4D0)
    val charsDark_onSurface = Color(0xFFE6E1E5)
    val charsDark_surfaceVariant = Color(0xFF49454F)
    val charsDark_surface = Color(0xFF1C1B1F)
    val charsDark_onSecondaryContainer = Color(0xFFE8DEF8)
    val charsDark_onSecondary = Color(0xFF332D41)
    val charsDark_secondaryContainer = Color(0xFF4A4458)
    val charsDark_secondary = Color(0xFFCCC2DC)
    val charsDark_inversePrimary = Color(0xFF6750A4)
    val charsDark_onPrimaryContainer = Color(0xFFEADDFF)
    val charsDark_onPrimary = Color(0xFF381E72)
    val charsDark_primaryContainer = Color(0xFF4F378B)
    val charsDark_primary = Color(0xFFD0BCFF)
}

val ColorScheme.charsSurfaceTint: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_surfaceTint
        else CharsColors.charsDark_surfaceTint


val ColorScheme.charsSurfaceTintColor: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_surfaceTintColor
        else CharsColors.charsDark_surfaceTintColor


val ColorScheme.charsOnErrorContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_onErrorContainer
        else CharsColors.charsDark_onErrorContainer


val ColorScheme.charsOnError: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_onError
        else CharsColors.charsDark_onError


val ColorScheme.charsErrorContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_errorContainer
        else CharsColors.charsDark_errorContainer


val ColorScheme.charsOnTertiaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_onTertiaryContainer
        else CharsColors.charsDark_onTertiaryContainer


val ColorScheme.charsOnTertiary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_onTertiary
        else CharsColors.charsDark_onTertiary


val ColorScheme.charsTertiaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_tertiaryContainer
        else CharsColors.charsDark_tertiaryContainer


val ColorScheme.charsTertiary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_tertiary
        else CharsColors.charsDark_tertiary


val ColorScheme.charsShadow: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_shadow
        else CharsColors.charsDark_shadow


val ColorScheme.charsError: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_error
        else CharsColors.charsDark_error


val ColorScheme.charsOutline: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_outline
        else CharsColors.charsDark_outline


val ColorScheme.charsOnBackground: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_onBackground
        else CharsColors.charsDark_onBackground


val ColorScheme.charsBackground: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_background
        else CharsColors.charsDark_background


val ColorScheme.charsInverseOnSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_inverseOnSurface
        else CharsColors.charsDark_inverseOnSurface


val ColorScheme.charsInverseSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_inverseSurface
        else CharsColors.charsDark_inverseSurface


val ColorScheme.charsOnSurfaceVariant: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_onSurfaceVariant
        else CharsColors.charsDark_onSurfaceVariant


val ColorScheme.charsOnSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_onSurface
        else CharsColors.charsDark_onSurface


val ColorScheme.charsSurfaceVariant: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_surfaceVariant
        else CharsColors.charsDark_surfaceVariant


val ColorScheme.charsSurface: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_surface
        else CharsColors.charsDark_surface


val ColorScheme.charsOnSecondaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_onSecondaryContainer
        else CharsColors.charsDark_onSecondaryContainer


val ColorScheme.charsOnSecondary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_onSecondary
        else CharsColors.charsDark_onSecondary


val ColorScheme.charsSecondaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_secondaryContainer
        else CharsColors.charsDark_secondaryContainer


val ColorScheme.charsSecondary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_secondary
        else CharsColors.charsDark_secondary


val ColorScheme.charsInversePrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_inversePrimary
        else CharsColors.charsDark_inversePrimary


val ColorScheme.charsOnPrimaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_onPrimaryContainer
        else CharsColors.charsDark_onPrimaryContainer


val ColorScheme.charsOnPrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_onPrimary
        else CharsColors.charsDark_onPrimary


val ColorScheme.charsPrimaryContainer: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_primaryContainer
        else CharsColors.charsDark_primaryContainer


val ColorScheme.charsPrimary: Color
    @Composable
    get() =
        if (!isSystemInDarkTheme()) CharsColors.charsLight_primary
        else CharsColors.charsDark_primary

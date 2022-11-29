package com.chrrissoft.marvel.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarvelScaffold(
    topAppBar: @Composable () -> Unit,
    navigationBar: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = { topAppBar() },
        bottomBar = { navigationBar() }
    ) { content(it) }
}
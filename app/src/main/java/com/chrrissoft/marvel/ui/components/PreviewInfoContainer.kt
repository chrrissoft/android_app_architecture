package com.chrrissoft.marvel.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceAround
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier

@Composable
fun AppearancesCountContainer(
    modifier: Modifier = Modifier,
    appearance0: @Composable () -> Unit,
    appearance1: @Composable () -> Unit,
    appearance2: @Composable () -> Unit,
    appearance3: @Composable () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxSize()
    ) {
        InfoColumContainer {
            appearance0()
            appearance1()
        }
        InfoColumContainer {
            appearance2()
            appearance3()
        }
    }
}

@Composable
private fun RowScope.InfoColumContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .weight(1f),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = SpaceAround
    ) { content() }
}

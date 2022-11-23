package com.chrrissoft.marvel.ui.chars.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.chrrissoft.marvel.ui.chars.Character
import com.chrrissoft.marvel.ui.chars.CharsScreenState

@Composable
internal fun CharInfo(
    info: Character,
    resState: CharsScreenState.InfoResState
) {
    if (info.isEmpty()) {
        Text(text = "Select a preview for watch an info")
    } else {
        Text(text = info.name)
    }
}
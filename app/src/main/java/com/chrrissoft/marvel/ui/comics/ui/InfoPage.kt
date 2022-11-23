package com.chrrissoft.marvel.ui.comics.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.chrrissoft.marvel.ui.comics.Comic
import com.chrrissoft.marvel.ui.comics.ComicsScreenState

@Composable
internal fun ComicInfoPage(
    info: Comic,
    resState: ComicsScreenState.InfoResState
) {
    if (info.isEmpty()) {
        Text(text = "Select a preview for watch an info")
    } else {
        Text(text = info.title)
    }
}
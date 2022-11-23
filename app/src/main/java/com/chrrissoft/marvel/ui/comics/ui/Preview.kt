package com.chrrissoft.marvel.ui.comics.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrrissoft.marvel.ui.comics.ComicsPreview
import com.chrrissoft.marvel.ui.components.AppearancesCount
import com.chrrissoft.marvel.ui.components.AppearancesCountContainer
import com.chrrissoft.marvel.ui.components.Preview

@Composable
internal fun ComicsPreviewUi(preview: ComicsPreview) {
    Preview(preview.image, title = preview.title) {
        AppearancesCountContainer(
            modifier = Modifier.weight(2f),
            appearance0 = { AppearancesCount(preview.charsCount, "chars") },
            appearance1 = { AppearancesCount(preview.seriesCount, "series") },
            appearance2 = { AppearancesCount(preview.storiesCount, "stories") },
            appearance3 = { AppearancesCount(preview.eventsCount, "events") }
        )
    }
}

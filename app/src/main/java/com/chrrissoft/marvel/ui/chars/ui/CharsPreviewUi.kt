package com.chrrissoft.marvel.ui.chars.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrrissoft.marvel.ui.chars.CharsPreview
import com.chrrissoft.marvel.ui.components.AppearancesCount
import com.chrrissoft.marvel.ui.components.AppearancesCountContainer
import com.chrrissoft.marvel.ui.components.Preview

@Composable
internal fun CharsPreviewUi(preview: CharsPreview) {
    Preview(preview.image, title = preview.name) {
        AppearancesCountContainer(
            modifier = Modifier.weight(2f),
            appearance0 = { AppearancesCount(preview.comicsCount, "comics") },
            appearance1 = { AppearancesCount(preview.seriesCount, "series") },
            appearance2 = { AppearancesCount(preview.storiesCount, "stories") },
            appearance3 = { AppearancesCount(preview.eventsCount, "events") }
        )
    }
}

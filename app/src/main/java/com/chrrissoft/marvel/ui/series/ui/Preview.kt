package com.chrrissoft.marvel.ui.series.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrrissoft.marvel.ui.components.AppearancesCount
import com.chrrissoft.marvel.ui.components.AppearancesCountContainer
import com.chrrissoft.marvel.ui.components.Preview
import com.chrrissoft.marvel.ui.series.SeriesPreview

@Composable
internal fun SeriesPreviewUi(preview: SeriesPreview) {
    Preview(preview.image, title = preview.title) {
        AppearancesCountContainer(
            modifier = Modifier.weight(2f),
            appearance0 = { AppearancesCount(preview.charsCount, "chars") },
            appearance1 = { AppearancesCount(preview.seriesCount, "series") },
            appearance2 = { AppearancesCount(preview.eventsCount, "stories") },
            appearance3 = { AppearancesCount(preview.comicsCount, "comics") }
        )
    }
}

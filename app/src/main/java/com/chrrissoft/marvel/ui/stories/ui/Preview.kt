package com.chrrissoft.marvel.ui.stories.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrrissoft.marvel.ui.components.AppearancesCount
import com.chrrissoft.marvel.ui.components.AppearancesCountContainer
import com.chrrissoft.marvel.ui.components.Preview
import com.chrrissoft.marvel.ui.stories.StoryPreview

@Composable
internal fun StoryPreviewUi(preview: StoryPreview) {
    Preview(preview.image, title = preview.title) {
        AppearancesCountContainer(
            modifier = Modifier.weight(2f),
            appearance0 = { AppearancesCount(preview.charsCount, "chars") },
            appearance1 = { AppearancesCount(preview.seriesCount, "series") },
            appearance2 = { AppearancesCount(preview.eventsCount, "event") },
            appearance3 = { AppearancesCount(preview.comicsCount, "comics") }
        )
    }
}

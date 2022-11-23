package com.chrrissoft.marvel.ui.stories.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.chrrissoft.marvel.ui.stories.StoriesScreenState
import com.chrrissoft.marvel.ui.stories.Story

@Composable
internal fun StoryInfoPage(
    info: Story,
    resState: StoriesScreenState.InfoResState
) {
    if (info.isEmpty()) {
        Text(text = "Select a preview for watch an info")
    } else {
        Text(text = info.title)
    }
}
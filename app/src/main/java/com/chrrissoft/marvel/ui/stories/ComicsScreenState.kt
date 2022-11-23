package com.chrrissoft.marvel.ui.stories

import com.chrrissoft.marvel.ui.stories.StoriesScreenState.PreviewResState.LOADING as PREVIEW_LOADING
import com.chrrissoft.marvel.ui.stories.StoriesScreenState.InfoResState.LOADING as INFO_LOADING
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW

data class StoriesScreenState(
    val screenPage: ScreenPage = PREVIEW,
    val info: Story = Story.emptyStory,
    val infoResState: InfoResState = INFO_LOADING,
    val previews: List<StoryPreview> = emptyList(),
    val previewResState: PreviewResState = PREVIEW_LOADING,
) {
    enum class PreviewResState {
        LOADING, ERROR, SUCCESS
    }

    enum class InfoResState {
        LOADING, ERROR, SUCCESS
    }
}
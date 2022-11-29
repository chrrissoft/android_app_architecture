package com.chrrissoft.marvel.ui.stories

import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.PREVIEW
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes

data class StoriesScreenState(
    val screenPage: ScreenPage = PREVIEW,
    val info: Story = Story.emptyStory,
    val previews: StoriesPrevRes = StoriesPrevRes(),
)

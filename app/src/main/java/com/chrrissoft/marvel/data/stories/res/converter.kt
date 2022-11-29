package com.chrrissoft.marvel.data.stories.res

import com.chrrissoft.marvel.data.stories.res.StoryResState.Error as DataError
import com.chrrissoft.marvel.data.stories.res.StoryResState.Loading as DataLoading
import com.chrrissoft.marvel.data.stories.res.StoryResState.Success as DataSuccess
import com.chrrissoft.marvel.ui.stories.res.StoryRes as UiStoryRes
import com.chrrissoft.marvel.ui.stories.res.StoryResState.Error as UiError
import com.chrrissoft.marvel.ui.stories.res.StoryResState.Loading as UiLoading
import com.chrrissoft.marvel.ui.stories.res.StoryResState.Success as UiSuccess


fun storyConverter(res: StoryRes): UiStoryRes {
    return when (res.state) {
        is DataError -> UiStoryRes(UiError(res.state.message))
        is DataLoading -> UiStoryRes(UiLoading(res.state.message))
        is DataSuccess -> UiStoryRes(UiSuccess(res.state.title, res.state.image))
    }
}

package com.chrrissoft.marvel.usecases.stories

import com.chrrissoft.marvel.data.stories.StoriesRepo
import javax.inject.Inject

class GetStoryUseCase @Inject constructor(
    private val repo: StoriesRepo,
) {
    operator fun invoke(id: Int) {}
}


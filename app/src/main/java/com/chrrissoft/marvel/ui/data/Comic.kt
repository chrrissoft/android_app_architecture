package com.chrrissoft.marvel.ui.data

import com.chrrissoft.marvel.ui.preview.CharacterPreview
import com.chrrissoft.marvel.ui.preview.EventPreview
import com.chrrissoft.marvel.ui.preview.SeriesPreview
import com.chrrissoft.marvel.ui.preview.StoriesPreview


data class Comic(
    val title: String,
    val image: Any,
    val characters: List<CharacterPreview>,
    val events: List<EventPreview>,
    val stories: List<StoriesPreview>,
    val series: List<SeriesPreview>
)

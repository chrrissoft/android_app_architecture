package com.chrrissoft.marvel.ui.chars

import androidx.compose.runtime.Composable
import com.chrrissoft.marvel.ui.chars.ui.CharsPreviewUi
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.series.res.SeriesPrevRes
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes


data class Character(
    val name: String,
    val image: Any,
    val comics: ComicsPrevRes,
    val events: EventsPrevRes,
    val stories: StoriesPrevRes,
    val series: SeriesPrevRes,
) {
    companion object {
        val emptyChar = Character(
            name = String(),
            image = Any(),
            comics = ComicsPrevRes(),
            events = EventsPrevRes(),
            stories = StoriesPrevRes(),
            series = SeriesPrevRes(),
        )
    }

    fun isEmpty() = this == emptyChar
}
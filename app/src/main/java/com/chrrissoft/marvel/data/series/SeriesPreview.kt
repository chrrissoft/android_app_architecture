package com.chrrissoft.marvel.data.series

import com.chrrissoft.marvel.ui.data.series.SeriesPreview

interface SeriesPreview {
    val id: Int
    val title: String
    val image: Any

    fun toUi() = SeriesPreview(id, title, image)
}

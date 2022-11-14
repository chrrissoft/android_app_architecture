package com.chrrissoft.marvel.data.preview

import com.chrrissoft.marvel.ui.preview.SeriesPreview

interface SeriesPreview {
    val id: Int
    val title: String
    val image: Any

    fun toUi() = SeriesPreview(id, title, image)
}

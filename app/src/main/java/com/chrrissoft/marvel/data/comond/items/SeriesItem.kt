package com.chrrissoft.marvel.data.comond.items

import com.chrrissoft.marvel.ui.characters.state.items.SeriesItem

interface SeriesItem {
    val resourceURI: String
    val name: String

    fun toUi() =
        SeriesItem(
            name = name,
            resourceURI = resourceURI,
        )
}
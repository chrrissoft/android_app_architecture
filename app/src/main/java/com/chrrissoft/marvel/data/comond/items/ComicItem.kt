package com.chrrissoft.marvel.data.comond.items

import com.chrrissoft.marvel.ui.characters.state.items.ComicItem

interface ComicItem {
    val resourceURI: String
    val name: String

    fun toUi() =
        ComicItem(
            name = name,
            resourceURI = resourceURI,
        )
}
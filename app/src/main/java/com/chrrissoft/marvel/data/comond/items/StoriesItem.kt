package com.chrrissoft.marvel.data.comond.items

import com.chrrissoft.marvel.ui.characters.state.items.StoriesItem


interface StoriesItem {
    val resourceURI: String
    val name: String
    val type: String

    fun toUi() =
        StoriesItem(
            resourceURI = resourceURI,
            name = name,
            type = type,
        )
}
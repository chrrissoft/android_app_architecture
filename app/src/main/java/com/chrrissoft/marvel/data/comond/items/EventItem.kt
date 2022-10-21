package com.chrrissoft.marvel.data.comond.items

import com.chrrissoft.marvel.ui.characters.state.items.EventItem

interface EventItem {
    val resourceURI: String
    val name: String
    val type: String

    fun toUI() =
        EventItem(
            resourceURI = resourceURI,
            name = name,
            type = type,
        )
}
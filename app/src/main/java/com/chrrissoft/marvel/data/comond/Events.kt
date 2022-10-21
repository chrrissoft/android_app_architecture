package com.chrrissoft.marvel.data.comond

import com.chrrissoft.marvel.data.comond.items.EventItem
import com.chrrissoft.marvel.ui.characters.state.info.Events


interface Events {
    val available: Int
    val collectionURI: String
    val items: List<EventItem>
    val returned: Int

    fun toUi() =
        Events(
            available = available,
            collectionURI = collectionURI,
            items = items.map { it.toUI() },
            returned = returned,
        )
}
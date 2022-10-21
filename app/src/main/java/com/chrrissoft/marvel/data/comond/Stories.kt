package com.chrrissoft.marvel.data.comond

import com.chrrissoft.marvel.data.comond.items.StoriesItem
import com.chrrissoft.marvel.ui.characters.state.info.Stories


interface Stories {
    val available: Int
    val collectionURI: String
    val items: List<StoriesItem>
    val returned: Int

    fun toUi() =
        Stories(
            available = available,
            collectionURI = collectionURI,
            items = items.map { it.toUi() },
            returned = returned,
        )
}
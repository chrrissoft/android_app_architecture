package com.chrrissoft.marvel.data.comond

import com.chrrissoft.marvel.framework.characters.models.items.ComicItem
import com.chrrissoft.marvel.ui.characters.state.info.Comics

interface Comics {
    val available: Int
    val collectionURI: String
    val items: List<ComicItem>
    val returned: Int

    fun toUi() =
        Comics(
            available = available,
            collectionURI = collectionURI,
            items = items.map { it.toUi() },
            returned = returned,
        )
}
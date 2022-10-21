package com.chrrissoft.marvel.data.comond

import com.chrrissoft.marvel.data.comond.items.SeriesItem
import com.chrrissoft.marvel.ui.characters.state.info.Series


interface Series {
    val available: Int
    val collectionURI: String
    val items: List<SeriesItem>
    val returned: Int

    fun toUI() =
        Series(
            available = available,
            collectionURI = collectionURI,
            items = items.map { it.toUi() },
            returned = returned,
        )
}

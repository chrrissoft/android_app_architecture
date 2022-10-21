package com.chrrissoft.marvel.ui.characters.state.info

import com.chrrissoft.marvel.ui.characters.state.items.ComicItem


data class Comics(
    val returned: Int = 0,
    val available: Int = 0,
    val collectionURI: String = "",
    val items: List<ComicItem> = arrayListOf(),
)


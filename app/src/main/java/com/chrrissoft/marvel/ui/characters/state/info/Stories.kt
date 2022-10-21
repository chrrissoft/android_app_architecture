package com.chrrissoft.marvel.ui.characters.state.info

import com.chrrissoft.marvel.ui.characters.state.items.StoriesItem

data class Stories(
    val returned: Int = 0,
    val available: Int = 0,
    val collectionURI: String = "",
    val items: List<StoriesItem> = arrayListOf(),
)


package com.chrrissoft.marvel.framework.characters.database.info

import com.chrrissoft.marvel.data.comond.Stories
import com.chrrissoft.marvel.data.comond.items.StoriesItem

data class Stories(
    override val available: Int = 0,
    override val collectionURI: String = "",
    override val items: List<StoriesItem> = emptyList(),
    override val returned: Int = 0,
) : Stories
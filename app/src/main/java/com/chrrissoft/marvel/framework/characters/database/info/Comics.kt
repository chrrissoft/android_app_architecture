package com.chrrissoft.marvel.framework.characters.database.info

import com.chrrissoft.marvel.data.comond.Comics
import com.chrrissoft.marvel.framework.characters.models.items.ComicItem

data class Comics(
    override val available: Int = 0,
    override val collectionURI: String = "",
    override val items: List<ComicItem> = emptyList(),
    override val returned: Int = 0,
) : Comics
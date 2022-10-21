package com.chrrissoft.marvel.framework.characters.database.info

import com.chrrissoft.marvel.data.comond.Series
import com.chrrissoft.marvel.data.comond.items.SeriesItem


data class Series(
    override val available: Int = 0,
    override val collectionURI: String = "",
    override val items: List<SeriesItem> = emptyList(),
    override val returned: Int = 0,
) : Series
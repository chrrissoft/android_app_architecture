package com.chrrissoft.marvel.framework.characters.database.items

import com.chrrissoft.marvel.data.comond.items.SeriesItem

data class SeriesItem(
    override val resourceURI: String,
    override val name: String,
) : SeriesItem
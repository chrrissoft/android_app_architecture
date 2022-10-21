package com.chrrissoft.marvel.framework.characters.database.items

import com.chrrissoft.marvel.data.comond.items.ComicItem

data class ComicItem(
    override val resourceURI: String,
    override val name: String,
) : ComicItem
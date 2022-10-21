package com.chrrissoft.marvel.framework.characters.database.items

import com.chrrissoft.marvel.data.comond.items.EventItem

data class EventItem(
    override val resourceURI: String,
    override val name: String,
    override val type: String,
) : EventItem
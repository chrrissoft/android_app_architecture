package com.chrrissoft.marvel.framework.characters.database.info

import com.chrrissoft.marvel.data.comond.Events
import com.chrrissoft.marvel.data.comond.items.EventItem

data class Events(
    override val available: Int = 0,
    override val collectionURI: String = "",
    override val items: List<EventItem> = emptyList(),
    override val returned: Int = 0,
) : Events
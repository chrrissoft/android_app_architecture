package com.chrrissoft.marvel.framework.characters.models.info

import com.chrrissoft.marvel.data.comond.Events
import com.chrrissoft.marvel.framework.characters.models.items.EventItem
import com.google.gson.annotations.SerializedName


//@JsonClass(generateAdapter = true)
data class Events(
    @SerializedName("available") override val available: Int = 0,
    @SerializedName("collectionURI") override val collectionURI: String = "",
    @SerializedName("items") override val items: List<EventItem> = listOf(),
    @SerializedName("returned") override val returned: Int = 0
) : Events
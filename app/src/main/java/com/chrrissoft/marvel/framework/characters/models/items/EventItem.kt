package com.chrrissoft.marvel.framework.characters.models.items

import com.chrrissoft.marvel.data.comond.items.EventItem
import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class EventItem(
    @SerializedName("resourceURI") override val resourceURI: String = "",
    @SerializedName("name") override val name: String = "",
    @SerializedName("type") override val type: String = "",
) : EventItem
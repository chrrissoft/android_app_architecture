package com.chrrissoft.marvel.framework.characters.models.items

import com.chrrissoft.marvel.data.comond.items.SeriesItem
import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class SeriesItem(
    @SerializedName("resourceURI") override val resourceURI: String = "",
    @SerializedName("name") override val name: String = ""
) : SeriesItem
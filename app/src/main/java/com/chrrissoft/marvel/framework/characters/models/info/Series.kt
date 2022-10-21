package com.chrrissoft.marvel.framework.characters.models.info

import com.chrrissoft.marvel.data.comond.Series
import com.chrrissoft.marvel.framework.characters.models.items.SeriesItem
import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class Series(
    @SerializedName("available") override val available: Int = 0,
    @SerializedName("collectionURI") override val collectionURI: String = "",
    @SerializedName("items") override val items: List<SeriesItem> = emptyList(),
    @SerializedName("returned") override val returned: Int = 0
) : Series
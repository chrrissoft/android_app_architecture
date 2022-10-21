package com.chrrissoft.marvel.framework.characters.models.info

import com.chrrissoft.marvel.data.comond.Stories
import com.chrrissoft.marvel.framework.characters.models.items.StoriesItem
import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class Stories(
    @SerializedName("available") override val available: Int = 0,
    @SerializedName("collectionURI") override val collectionURI: String ="",
    @SerializedName("items") override val items: List<StoriesItem> = emptyList(),
    @SerializedName("returned") override val returned: Int = 0
) : Stories
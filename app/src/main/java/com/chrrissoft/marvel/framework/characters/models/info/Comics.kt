package com.chrrissoft.marvel.framework.characters.models.info

import com.chrrissoft.marvel.data.comond.Comics
import com.chrrissoft.marvel.framework.characters.models.items.ComicItem
import com.google.gson.annotations.SerializedName

data class Comics(
    @SerializedName("returned") override val returned: Int = 0,
    @SerializedName("available") override val available: Int = 0,
    @SerializedName("items") override val items: List<ComicItem> = arrayListOf(),
    @SerializedName("collectionURI") override val collectionURI: String = "",
) : Comics
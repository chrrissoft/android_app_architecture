package com.chrrissoft.marvel.framework.characters.models.items

import com.chrrissoft.marvel.data.comond.items.StoriesItem
import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class StoriesItem(
    @SerializedName("resourceURI") override val resourceURI: String = "",
    @SerializedName("name") override val name: String = "",
    @SerializedName("type") override val type: String = "",
) : StoriesItem
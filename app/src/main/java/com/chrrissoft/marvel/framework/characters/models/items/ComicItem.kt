package com.chrrissoft.marvel.framework.characters.models.items

import com.chrrissoft.marvel.data.comond.items.ComicItem
import com.google.gson.annotations.SerializedName


data class ComicItem(
    @SerializedName("resourceURI") override val resourceURI: String,
    @SerializedName("name") override val name: String,
) : ComicItem
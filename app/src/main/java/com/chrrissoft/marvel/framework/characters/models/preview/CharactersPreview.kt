package com.chrrissoft.marvel.framework.characters.models.preview

import com.chrrissoft.marvel.data.characters.models.CharactersPreview
import com.chrrissoft.marvel.framework.characters.models.Thumbnail
import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class CharactersPreview(
    @SerializedName("id") override val id: Int = 0,
    @SerializedName("name") override val name: String = "",
    @SerializedName("thumbnail") override val thumbnail: Thumbnail = Thumbnail(),
) : CharactersPreview
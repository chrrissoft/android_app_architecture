package com.chrrissoft.marvel.framework.characters.api

import com.chrrissoft.marvel.data.preview.CharacterPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import com.google.gson.annotations.SerializedName


data class CharacterResult(
    @SerializedName("id") override val id: Int,
    @SerializedName("name") override val name: String,
    @SerializedName("thumbnail") override val image: Thumbnail,
) : CharacterPreview
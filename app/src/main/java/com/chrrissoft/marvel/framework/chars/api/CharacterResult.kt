package com.chrrissoft.marvel.framework.chars.api

import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import com.google.gson.annotations.SerializedName


data class CharacterResult(
    @SerializedName("id") override val id: Int,
    @SerializedName("name") override val name: String,
    @SerializedName("thumbnail") override val image: Thumbnail,
) : CharsPreview
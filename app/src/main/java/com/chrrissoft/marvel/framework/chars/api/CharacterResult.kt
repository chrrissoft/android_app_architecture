package com.chrrissoft.marvel.framework.chars.api

import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import com.google.gson.annotations.SerializedName


data class CharacterResult(
    @SerializedName("id") override val id: Int = 0,
    @SerializedName("name") override val name: String,
    @SerializedName("thumbnail") override val image: Thumbnail,
) : CharsPreview {
    companion object {
        val emptyResult = CharacterResult(
            id = 0, name = "", image = Thumbnail("", "")
        )
    }

    override fun convertImage(): Any {
        val image = image.path + "." + image.extension
        return image.replace("http:", "https:")
    }
}

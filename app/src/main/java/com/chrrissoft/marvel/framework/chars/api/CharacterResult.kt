package com.chrrissoft.marvel.framework.chars.api

import com.chrrissoft.marvel.data.chars.CharsPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResult(
    @SerialName("id") override val id: Int = 0,
    @SerialName("name") override val name: String,
    @SerialName("thumbnail") override val image: Thumbnail,
) : CharsPreview {
    override fun convertImage(): Any {
        val image = image.path + "." + image.extension
        return image.replace("http:", "https:")
    }
}

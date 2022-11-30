package com.chrrissoft.marvel.framework.series.api

import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesResult(
    @SerialName("id") override val id: Int,
    @SerialName("title") override val title: String,
    @SerialName("thumbnail") override val image: Thumbnail,
) : SeriesPreview {
    override fun convertImage(): Any {
        val image = image.path + "." + image.extension
        return image.replace("http:", "https:")
    }
}
package com.chrrissoft.marvel.framework.events.api

import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EventsResult(
    @SerialName("id") override val id: Int,
    @SerialName("title") override val title: String,
    @SerialName("thumbnail") override val image: Thumbnail?,
) : EventPreview {
    override fun convertImage(): Any {
        val image = image?.path + "." + image?.extension
        return image.replace("http:", "https:")
    }
}
package com.chrrissoft.marvel.framework.events.api

import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EventsResult(
    @SerialName("id") override val id: Int,
    @SerialName("name") override val title: String,
    @SerialName("thumbnail") override val image: Thumbnail,
) : EventPreview
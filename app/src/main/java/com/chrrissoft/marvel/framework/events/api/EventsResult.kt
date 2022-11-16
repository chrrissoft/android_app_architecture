package com.chrrissoft.marvel.framework.events.api

import com.chrrissoft.marvel.data.events.EventPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import com.google.gson.annotations.SerializedName


data class EventsResult(
    @SerializedName("id") override val id: Int,
    @SerializedName("name") override val title: String,
    @SerializedName("thumbnail") override val image: Thumbnail,
) : EventPreview
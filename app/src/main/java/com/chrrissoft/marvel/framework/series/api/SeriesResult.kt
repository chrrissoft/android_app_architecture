package com.chrrissoft.marvel.framework.series.api

import com.chrrissoft.marvel.data.series.SeriesPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesResult(
    @SerialName("id") override val id: Int,
    @SerialName("name") override val title: String,
    @SerialName("thumbnail") override val image: Thumbnail,
) : SeriesPreview
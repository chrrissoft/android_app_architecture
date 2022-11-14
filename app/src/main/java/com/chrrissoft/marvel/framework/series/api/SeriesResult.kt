package com.chrrissoft.marvel.framework.series.api

import com.chrrissoft.marvel.data.preview.SeriesPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import com.google.gson.annotations.SerializedName


data class SeriesResult(
    @SerializedName("id") override val id: Int,
    @SerializedName("name") override val title: String,
    @SerializedName("thumbnail") override val image: Thumbnail,
) : SeriesPreview
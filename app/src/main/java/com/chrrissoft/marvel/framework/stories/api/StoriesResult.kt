package com.chrrissoft.marvel.framework.stories.api

import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import com.google.gson.annotations.SerializedName


data class StoriesResult(
    @SerializedName("id") override val id: Int,
    @SerializedName("name") override val title: String,
    @SerializedName("thumbnail") override val image: Thumbnail,
) : StoriesPreview
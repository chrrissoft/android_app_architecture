package com.chrrissoft.marvel.framework.stories.api

import com.chrrissoft.marvel.data.stories.StoriesPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoriesResult(
    @SerialName("id") override val id: Int,
    @SerialName("name") override val title: String,
    @SerialName("thumbnail") override val image: Thumbnail,
) : StoriesPreview
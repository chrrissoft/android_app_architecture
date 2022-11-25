package com.chrrissoft.marvel.framework.comics.api

import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComicsResult(
    @SerialName("id") override val id: Int,
    @SerialName("name") override val title: String,
    @SerialName("thumbnail") override val image: Thumbnail,
) : ComicPreview
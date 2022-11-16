package com.chrrissoft.marvel.framework.comics.api

import com.chrrissoft.marvel.data.comics.ComicPreview
import com.chrrissoft.marvel.framework.common.Thumbnail
import com.google.gson.annotations.SerializedName


data class ComicsResult(
    @SerializedName("id") override val id: Int,
    @SerializedName("name") override val title: String,
    @SerializedName("thumbnail") override val image: Thumbnail,
) : ComicPreview
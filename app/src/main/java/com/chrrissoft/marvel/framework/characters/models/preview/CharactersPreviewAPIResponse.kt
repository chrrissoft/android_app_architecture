package com.chrrissoft.marvel.framework.characters.models.preview

import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class CharactersPreviewAPIResponse(
    @SerializedName("code") var code : Int           = 0,
    @SerializedName("data") var data : DataPreview   = DataPreview()
)
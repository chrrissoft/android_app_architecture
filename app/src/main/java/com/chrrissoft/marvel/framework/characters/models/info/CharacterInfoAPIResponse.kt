package com.chrrissoft.marvel.framework.characters.models.info

import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class CharacterInfoAPIResponse(
    @SerializedName("code") val code: Int = 0,
    @SerializedName("data") val data: DataInfo = DataInfo()
)
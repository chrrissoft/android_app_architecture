package com.chrrissoft.marvel.framework.characters.models.preview

import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class DataPreview(
    @SerializedName("offset"  ) var offset  : Int?               = null,
    @SerializedName("limit"   ) var limit   : Int?               = null,
    @SerializedName("total"   ) var total   : Int?               = null,
    @SerializedName("count"   ) var count   : Int?               = null,
    @SerializedName("results" ) var results : List<CharactersPreview> = arrayListOf()
)


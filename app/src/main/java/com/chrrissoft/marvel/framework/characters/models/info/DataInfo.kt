package com.chrrissoft.marvel.framework.characters.models.info

import com.google.gson.annotations.SerializedName

//@JsonClass(generateAdapter = true)
data class DataInfo (
  @SerializedName("offset"  ) val offset  : Int = 0,
  @SerializedName("limit"   ) val limit   : Int = 0,
  @SerializedName("total"   ) val total   : Int = 0,
  @SerializedName("count"   ) val count   : Int = 0,
  @SerializedName("results" ) val results : ArrayList<CharacterInfo> = arrayListOf()
)
package com.chrrissoft.marvel.framework.series.api

import com.google.gson.annotations.SerializedName


data class Series (

  @SerializedName("code"  ) var code   : Int,
  @SerializedName("status") var status : String,
  @SerializedName("data"  ) var data   : SeriesData

)
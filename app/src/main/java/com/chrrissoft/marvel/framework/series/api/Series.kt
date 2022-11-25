package com.chrrissoft.marvel.framework.series.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Series (

  @SerialName("code"  ) var code   : Int,
  @SerialName("status") var status : String,
  @SerialName("data"  ) var data   : SeriesData

)
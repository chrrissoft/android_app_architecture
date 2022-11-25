package com.chrrissoft.marvel.framework.comics.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Comics (

  @SerialName("code"  ) var code   : Int,
  @SerialName("status") var status : String,
  @SerialName("data"  ) var data   : ComicsData

)
package com.chrrissoft.marvel.framework.stories.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stories (

  @SerialName("code"  ) var code   : Int,
  @SerialName("status") var status : String,
  @SerialName("data"  ) var data   : StoriesData

)
package com.chrrissoft.marvel.framework.chars.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Characters (

  @SerialName("code"  ) var code   : Int,
  @SerialName("status") var status : String,
  @SerialName("data"  ) var data   : CharactersData

)
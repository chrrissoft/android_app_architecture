package com.chrrissoft.marvel.framework.events.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Events (

  @SerialName("code"  ) var code   : Int,
  @SerialName("status") var status : String,
  @SerialName("data"  ) var data   : EventsData

)
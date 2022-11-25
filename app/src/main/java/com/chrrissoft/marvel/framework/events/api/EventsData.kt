package com.chrrissoft.marvel.framework.events.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EventsData (

  @SerialName("total"   ) var total   : Int,
  @SerialName("results" ) var results : ArrayList<EventsResult>

)
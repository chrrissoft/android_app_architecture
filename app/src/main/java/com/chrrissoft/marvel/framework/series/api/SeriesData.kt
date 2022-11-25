package com.chrrissoft.marvel.framework.series.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesData (

  @SerialName("total"   ) var total   : Int,
  @SerialName("results" ) var results : ArrayList<SeriesResult>

)
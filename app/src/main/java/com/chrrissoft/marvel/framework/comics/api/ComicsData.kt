package com.chrrissoft.marvel.framework.comics.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComicsData (

  @SerialName("total"   ) var total   : Int,
  @SerialName("results" ) var results : ArrayList<ComicsResult>

)
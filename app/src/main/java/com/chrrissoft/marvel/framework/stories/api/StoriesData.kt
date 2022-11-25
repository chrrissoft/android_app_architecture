package com.chrrissoft.marvel.framework.stories.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoriesData (

  @SerialName("total"   ) var total   : Int,
  @SerialName("results" ) var results : ArrayList<StoriesResult>

)
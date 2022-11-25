package com.chrrissoft.marvel.framework.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail (

  @SerialName("path"      ) var path      : String,
  @SerialName("extension" ) var extension : String

)
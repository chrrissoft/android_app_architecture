package com.chrrissoft.marvel.framework.common

import com.google.gson.annotations.SerializedName


data class Thumbnail (

  @SerializedName("path"      ) var path      : String,
  @SerializedName("extension" ) var extension : String

)
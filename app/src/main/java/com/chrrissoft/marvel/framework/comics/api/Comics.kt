package com.chrrissoft.marvel.framework.comics.api

import com.google.gson.annotations.SerializedName


data class Comics (

  @SerializedName("code"  ) var code   : Int,
  @SerializedName("status") var status : String,
  @SerializedName("data"  ) var data   : ComicsData

)
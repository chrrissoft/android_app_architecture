package com.chrrissoft.marvel.framework.stories.api

import com.google.gson.annotations.SerializedName


data class Stories (

  @SerializedName("code"  ) var code   : Int,
  @SerializedName("status") var status : String,
  @SerializedName("data"  ) var data   : StoriesData

)
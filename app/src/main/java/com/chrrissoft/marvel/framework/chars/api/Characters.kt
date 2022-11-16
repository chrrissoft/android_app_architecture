package com.chrrissoft.marvel.framework.chars.api

import com.google.gson.annotations.SerializedName


data class Characters (

  @SerializedName("code"  ) var code   : Int,
  @SerializedName("status") var status : String,
  @SerializedName("data"  ) var data   : CharactersData

)
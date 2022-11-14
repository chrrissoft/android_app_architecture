package com.chrrissoft.marvel.framework.events.api

import com.google.gson.annotations.SerializedName


data class Events (

  @SerializedName("code"  ) var code   : Int,
  @SerializedName("status") var status : String,
  @SerializedName("data"  ) var data   : EventsData

)
package com.chrrissoft.marvel.framework.events.api

import com.google.gson.annotations.SerializedName


data class EventsData (

  @SerializedName("total"   ) var total   : Int,
  @SerializedName("results" ) var results : ArrayList<EventsResult>

)
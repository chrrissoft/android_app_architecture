package com.chrrissoft.marvel.framework.series.api

import com.google.gson.annotations.SerializedName


data class SeriesData (

  @SerializedName("total"   ) var total   : Int,
  @SerializedName("results" ) var results : ArrayList<SeriesResult>

)
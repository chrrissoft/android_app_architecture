package com.chrrissoft.marvel.framework.comics.api

import com.google.gson.annotations.SerializedName


data class ComicsData (

  @SerializedName("total"   ) var total   : Int,
  @SerializedName("results" ) var results : ArrayList<ComicsResult>

)
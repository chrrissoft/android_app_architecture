package com.chrrissoft.marvel.framework.stories.api

import com.google.gson.annotations.SerializedName


data class StoriesData (

  @SerializedName("total"   ) var total   : Int,
  @SerializedName("results" ) var results : ArrayList<StoriesResult>

)
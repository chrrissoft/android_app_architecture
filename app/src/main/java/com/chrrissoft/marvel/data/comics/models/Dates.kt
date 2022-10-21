package com.chrrissoft.marvel.data.comics.models

import com.google.gson.annotations.SerializedName


data class Dates (

  @SerializedName("type" ) var type : String? = null,
  @SerializedName("date" ) var date : String? = null

)
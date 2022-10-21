package com.chrrissoft.marvel.data.comics.models

import com.google.gson.annotations.SerializedName


data class Prices (

  @SerializedName("type"  ) var type  : String? = null,
  @SerializedName("price" ) var price : Int?    = null

)
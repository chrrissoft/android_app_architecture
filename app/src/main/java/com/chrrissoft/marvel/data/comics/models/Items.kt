package com.chrrissoft.marvel.data.comics.models

import com.google.gson.annotations.SerializedName


data class Items (

  @SerializedName("resourceURI" ) var resourceURI : String? = null,
  @SerializedName("name"        ) var name        : String? = null,
  @SerializedName("type"        ) var type        : String? = null

)
package com.chrrissoft.marvel.framework.chars.api

import com.google.gson.annotations.SerializedName


data class CharactersData (

  @SerializedName("total"   ) var total   : Int,
  @SerializedName("results" ) var results : ArrayList<CharacterResult>

)
package com.chrrissoft.marvel.framework.characters.api

import com.google.gson.annotations.SerializedName


data class CharactersData (

  @SerializedName("total"   ) var total   : Int,
  @SerializedName("results" ) var results : ArrayList<CharacterResult>

)
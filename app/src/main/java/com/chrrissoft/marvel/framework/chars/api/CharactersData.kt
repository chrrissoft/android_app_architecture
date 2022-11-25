package com.chrrissoft.marvel.framework.chars.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersData (

  @SerialName("total"   ) var total   : Int,
  @SerialName("results" ) var results : ArrayList<CharacterResult>

)
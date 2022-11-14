package com.chrrissoft.marvel.data.characters

sealed interface CharactersResState {

    data class CharacterError(
        val message: Exception
    ) : CharactersResState

    data class CharacterSuccess(
        val data: Character
    ) : CharactersResState

    data class CharacterLoading(
        val message: Nothing? = null
    ) : CharactersResState

}
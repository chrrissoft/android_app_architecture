package com.chrrissoft.marvel.data.characters

import com.chrrissoft.marvel.data.preview.CharacterPreview

sealed interface CharsPrevResState {

    data class CharsPrevError(
        val message: Exception
    ) : CharsPrevResState

    data class CharsPrevSuccess(
        val data: List<CharacterPreview>
    ) : CharsPrevResState

    data class CharsPrevLoading(
        val message: Nothing? = null
    ) : CharsPrevResState

}
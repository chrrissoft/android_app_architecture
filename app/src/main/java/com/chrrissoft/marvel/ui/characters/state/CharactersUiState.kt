package com.chrrissoft.marvel.ui.characters.state

import com.chrrissoft.marvel.ui.characters.state.info.CharacterInfo
import com.chrrissoft.marvel.ui.characters.state.preview.CharacterPreview

data class CharactersUiState(
    val characterInfo: CharacterInfo = CharacterInfo(),
    val characters: List<CharacterPreview> = emptyList(),
)
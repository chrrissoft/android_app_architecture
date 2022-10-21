package com.chrrissoft.marvel.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrrissoft.marvel.ui.characters.state.CharactersUiState
import com.chrrissoft.marvel.usecases.characters.GetCharacterInfoUseCase
import com.chrrissoft.marvel.usecases.characters.GetCharactersPreviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterInfo: GetCharacterInfoUseCase,
    private val getAllCharacters: GetCharactersPreviewUseCase,
) : ViewModel() {

    private val _tag = "CharacterViewModel"

    private val _uiState = MutableStateFlow(CharactersUiState())
    val uiState = _uiState.asStateFlow()

    fun getChars() {
        viewModelScope.launch {
            getAllCharacters()
//            _uiState.update { it.copy(characters = getAllCharacters()) }
        }
    }

    fun getCharInfo(id: Int) {
        viewModelScope.launch {
            _uiState.update { it.copy(characterInfo = getCharacterInfo(id)) }
        }
    }

}







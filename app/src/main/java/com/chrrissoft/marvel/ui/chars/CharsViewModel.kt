package com.chrrissoft.marvel.ui.chars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrrissoft.marvel.ui.chars.CharsScreenState.PreviewResState.*
import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.chars.res.CharsPrevResState.*
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.usecases.chars.GetCharUseCase
import com.chrrissoft.marvel.usecases.chars.GetCharsPrevUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharsViewModel @Inject constructor(
    private val getCharacterInfoUseCase: GetCharUseCase,
    private val getCharsPrevUseCase: GetCharsPrevUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "CharsViewModel"
    }

    private val _uiState = MutableStateFlow(CharsScreenState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getCharsPrevUseCase.collectGetBySource()
        }
        collectRes()
        loadRes()
    }

    fun changeScreenState(state: ScreenPage) {
        _uiState.update { it.copy(screenPage = state) }
    }

    fun loadRes() {
        viewModelScope.launch {
            getCharsPrevUseCase.invoke()
        }
    }

    private fun collectRes() {
        viewModelScope.launch {
            getCharsPrevUseCase.res.collect {
                updatePrevRes(it)
            }
        }
    }

    private fun updatePrevRes(res: CharsPrevRes) {
        _uiState.update {
            when (res.state) {
                is Error -> {
                    it.copy(previews = res.state.data, previewResState = ERROR)
                }
                is Loading -> {
                    it.copy(previews = res.state.data, previewResState = LOADING)
                }
                is Success -> {
                    it.copy(previews = res.state.data, previewResState = SUCCESS)
                }
            }
        }
    }
}


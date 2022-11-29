package com.chrrissoft.marvel.ui.chars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.usecases.chars.GetCharUseCase
import com.chrrissoft.marvel.usecases.chars.GetCharsPrevUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharsViewModel @Inject constructor(
    private val getCharUseCase: GetCharUseCase,
    private val getCharsPrevUseCase: GetCharsPrevUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "CharsViewModel"
    }

    private val _uiState = MutableStateFlow(CharsScreenState())
    val uiState = _uiState.asStateFlow()

    init {
//        initGetPreviewUseCase()
//        loadPreview()
//        collectRes()
    }

    fun changeScreenState(state: ScreenPage) {
        _uiState.update { it.copy(screenPage = state) }
    }

    fun loadPreview() {
        viewModelScope.launch {
            getCharsPrevUseCase.getChars()
        }
    }

    private fun collectRes() {
        viewModelScope.launch(IO) {
            getCharsPrevUseCase.res.collect {
                updatePrevRes(it)
            }
        }
    }

    private fun initGetPreviewUseCase() {
        viewModelScope.launch {
            getCharsPrevUseCase.init()
        }
    }

    private fun updatePrevRes(res: CharsPrevRes) {
        _uiState.update { it.copy(previews = res) }
    }
}



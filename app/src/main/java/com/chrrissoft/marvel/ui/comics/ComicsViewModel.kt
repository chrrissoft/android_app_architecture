package com.chrrissoft.marvel.ui.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.usecases.comics.GetComicUseCase
import com.chrrissoft.marvel.usecases.comics.GetComicsPrevUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val getComicInfoUseCase: GetComicUseCase,
    private val getComicsPrevUseCase: GetComicsPrevUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "CharsViewModel"
    }

    private val _uiState = MutableStateFlow(ComicsScreenState())
    val uiState = _uiState.asStateFlow()

    init {
        collectGetBySource()
        load()
    }

    fun changeScreenState(state: ScreenPage) {
        _uiState.update { it.copy(screenPage = state) }
    }

    fun load() {
        viewModelScope.launch {
            getComicsPrevUseCase.res.collect {
                updatePrevRes(it)
            }
        }
    }


    private fun collectGetBySource() {
        viewModelScope.launch {
            getComicsPrevUseCase.collectGetBySource()
        }
    }

    private fun updatePrevRes(res: ComicsPrevRes) {
        _uiState.update { it.copy(previews = res) }
    }
}


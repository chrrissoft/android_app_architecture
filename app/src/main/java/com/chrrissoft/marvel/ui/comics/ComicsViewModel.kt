package com.chrrissoft.marvel.ui.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.usecases.comics.GetComicUseCase
import com.chrrissoft.marvel.usecases.comics.GetComicsPrevUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val getInfoUseCase: GetComicUseCase,
    private val getPreviewsUseCase: GetComicsPrevUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "CharsViewModel"
    }

    private val _uiState = MutableStateFlow(ComicsScreenState())
    val uiState = _uiState.asStateFlow()

    init {
        loadPreview()
        collectPreviews()
    }

    /*******************  previews  *******************/

    fun loadPreview() {
        viewModelScope.launch {
            getPreviewsUseCase
        }
    }

    private fun collectPreviews() {
        viewModelScope.launch(Dispatchers.IO) {
            getPreviewsUseCase.res.collect {
                updatePreviews(it)
            }
        }
    }

    private fun updatePreviews(res: ComicsPrevRes) {
        _uiState.update { it.copy(previews = res) }
    }

    private fun initGetInfoUseCase() {
        viewModelScope.launch {
            getInfoUseCase.init()
        }
    }

    /*******************  state changes  *******************/

    fun changeScreenState(state: ScreenPage) {
        _uiState.update { it.copy(screenPage = state) }
    }
}


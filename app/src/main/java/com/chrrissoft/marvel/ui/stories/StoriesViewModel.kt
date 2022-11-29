package com.chrrissoft.marvel.ui.stories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevResState
import com.chrrissoft.marvel.usecases.stories.GetStoriesPrevUseCase
import com.chrrissoft.marvel.usecases.stories.GetStoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoriesViewModel @Inject constructor(
    private val getStoryUseCase: GetStoryUseCase,
    private val getStoriesPrevUseCase: GetStoriesPrevUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "EventsViewModel"
    }

    private val _uiState = MutableStateFlow(StoriesScreenState())
    val uiState = _uiState.asStateFlow()

    init {
        initGetBySourceUseCase()
        collectGetBySource()
        load()
    }

    fun changeScreenPage(state: ScreenPage) {
        _uiState.update { it.copy(screenPage = state) }
    }

    fun load() {
        viewModelScope.launch {
            getStoriesPrevUseCase.res.collect {
                updatePrevRes(it)
            }
        }
    }

    private fun initGetBySourceUseCase() {
        viewModelScope.launch {
        }
    }

    private fun collectGetBySource() {
        viewModelScope.launch {
            getStoriesPrevUseCase.collectGetBySource()
        }
    }

    private fun updatePrevRes(res: StoriesPrevRes) {
        _uiState.update { it.copy(previews = res) }
    }
}

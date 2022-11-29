package com.chrrissoft.marvel.ui.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.series.res.SeriesPrevRes
import com.chrrissoft.marvel.usecases.series.GetSerieUseCase
import com.chrrissoft.marvel.usecases.series.GetSeriesPrevUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val getEventUseCase: GetSerieUseCase,
    private val getEventsPrevUseCase: GetSeriesPrevUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "EventsViewModel"
    }

    private val _uiState = MutableStateFlow(SeriesScreenState())
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
            getEventsPrevUseCase.res.collect {
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
            getEventsPrevUseCase.collectGetBySource()
        }
    }

    private fun updatePrevRes(res: SeriesPrevRes) {
        _uiState.update { it.copy(previews = res) }
    }
}

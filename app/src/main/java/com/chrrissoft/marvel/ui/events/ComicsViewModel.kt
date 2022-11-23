package com.chrrissoft.marvel.ui.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrrissoft.marvel.ui.events.EventsScreenState.PreviewResState
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.events.EventsScreenState.PreviewResState.*
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.events.res.EventsPrevResState
import com.chrrissoft.marvel.usecases.events.GetEventUseCase
import com.chrrissoft.marvel.usecases.events.GetEventsPrevUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val getEventUseCase: GetEventUseCase,
    private val getEventsPrevUseCase: GetEventsPrevUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "EventsViewModel"
    }

    private val _uiState = MutableStateFlow(EventsScreenState())
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
            getEventsPrevUseCase.initGetBySourceUseCase()
        }
    }

    private fun collectGetBySource() {
        viewModelScope.launch {
            getEventsPrevUseCase.collectGetBySource()
        }
    }

    private fun updatePrevRes(res: EventsPrevRes) {
        _uiState.update {
            when (res.state) {
                is EventsPrevResState.Error -> {
                    it.copy(
                        previews = res.state.data,
                        previewResState = ERROR
                    )
                }
                is EventsPrevResState.Loading -> {
                    it.copy(
                        previews = res.state.data,
                        previewResState = LOADING
                    )
                }
                is EventsPrevResState.Success -> {
                    it.copy(
                        previews = res.state.data,
                        previewResState = SUCCESS
                    )
                }
            }
        }
    }
}

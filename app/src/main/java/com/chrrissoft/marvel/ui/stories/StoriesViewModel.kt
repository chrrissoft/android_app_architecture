package com.chrrissoft.marvel.ui.stories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.INFO
import com.chrrissoft.marvel.usecases.stories.GetStoryUseCase
import com.chrrissoft.marvel.usecases.stories.GetStoriesPrevUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class StoriesViewModel @Inject constructor(
    private val getInfoUseCase: GetStoryUseCase,
    private val getPreviewsUseCase: GetStoriesPrevUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(StoriesScreenState())
    val uiState = _uiState.asStateFlow()
    private var cachedId: Int? = null // used to load its info still it not is load

    init {
        initGetPreviewsUseCase()
        loadPreviews()
        collectPreviews()

        initGetInfoUseCase()
        collectInfo()
    }

    /*******************  previews  *******************/

    fun loadPreviews() {
        viewModelScope.launch {
            getPreviewsUseCase.getChars()
        }
    }

    private fun collectPreviews() {
        viewModelScope.launch(IO) {
            getPreviewsUseCase.res.collect {
                withContext(Main) { updatePreviews(it) }
            }
        }
    }

    private fun updatePreviews(res: StoriesPrevRes) {
        _uiState.update { it.copy(previews = res) }
    }

    private fun initGetPreviewsUseCase() {
        viewModelScope.launch { getPreviewsUseCase.init() }
    }

    /*******************  info  *******************/


    fun loadInfo(id: Int) {
        if (cachedId == id) changeScreenPage(INFO)
        else {
            cachedId = id
            loadChars()
            loadComics()
            loadSeries()
            loadEvents()
            changeScreenPage(INFO)
        }
    }

    fun loadChars() {
        viewModelScope.launch { cachedId?.let { getInfoUseCase.loadChars(it) } }
    }

    fun loadComics() {
        viewModelScope.launch { cachedId?.let { getInfoUseCase.loadComics(it) } }
    }

    fun loadEvents() {
        viewModelScope.launch { cachedId?.let { getInfoUseCase.loadEvents(it) } }
    }

    fun loadSeries() {
        viewModelScope.launch { cachedId?.let { getInfoUseCase.loadSeries(it) } }
    }

    private fun collectInfo() {
        viewModelScope.launch(IO) {
            getInfoUseCase.res.collect {
                withContext(Main) { updateInfo(it) }
            }
        }
    }

    private fun updateInfo(res: Story) {
        _uiState.update { it.copy(info = res) }
    }

    private fun initGetInfoUseCase() {
        viewModelScope.launch {
            getInfoUseCase.init()
        }
    }


    /*******************  state changes  *******************/

    fun changeScreenPage(state: ScreenPage) {
        _uiState.update { it.copy(screenPage = state) }
    }

}

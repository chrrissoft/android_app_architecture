package com.chrrissoft.marvel.ui.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.INFO
import com.chrrissoft.marvel.usecases.comics.GetComicUseCase
import com.chrrissoft.marvel.usecases.comics.GetComicsPrevUseCase
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
class ComicsViewModel @Inject constructor(
    private val getInfoUseCase: GetComicUseCase,
    private val getPreviewsUseCase: GetComicsPrevUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ComicsScreenState())
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

    private fun updatePreviews(res: ComicsPrevRes) {
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
            loadSeries()
            loadStories()
            loadEvents()
            changeScreenPage(INFO)
        }
    }

    fun loadComic() {
        viewModelScope.launch { cachedId?.let { getInfoUseCase.loadComic(it) } }
    }

    fun loadChars() {
        viewModelScope.launch { cachedId?.let { getInfoUseCase.loadChars(it) } }
    }

    fun loadSeries() {
        viewModelScope.launch { cachedId?.let { getInfoUseCase.loadSeries(it) } }
    }

    fun loadStories() {
        viewModelScope.launch { cachedId?.let { getInfoUseCase.loadStories(it) } }
    }

    fun loadEvents() {
        viewModelScope.launch { cachedId?.let { getInfoUseCase.loadEvents(it) } }
    }

    private fun collectInfo() {
        viewModelScope.launch(IO) {
            getInfoUseCase.res.collect {
                withContext(Main) { updateInfo(it) }
            }
        }
    }

    private fun updateInfo(res: Comic) {
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

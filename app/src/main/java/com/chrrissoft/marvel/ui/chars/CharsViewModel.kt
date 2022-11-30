package com.chrrissoft.marvel.ui.chars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrrissoft.marvel.data.chars.CharsRepo.RequestOf
import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.ui.common.ScreenPage
import com.chrrissoft.marvel.ui.common.ScreenPage.INFO
import com.chrrissoft.marvel.usecases.chars.GetCharUseCase
import com.chrrissoft.marvel.usecases.chars.GetCharsPrevUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@HiltViewModel
class CharsViewModel @Inject constructor(
    private val getInfoUseCase: GetCharUseCase,
    private val getPreviewsUseCase: GetCharsPrevUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "CharsViewModel"
    }

    private val _uiState = MutableStateFlow(CharsScreenState())
    val uiState = _uiState.asStateFlow()
    var cachedId: Int? = null // used to load its info still it not is load
        private set

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
                updatePreviews(it)
            }
        }
    }

    private fun updatePreviews(res: CharsPrevRes) {
        _uiState.update { it.copy(previews = res) }
    }

    private fun initGetPreviewsUseCase() {
        viewModelScope.launch {
            getPreviewsUseCase.init()
        }
    }

    /*******************  info  *******************/


    fun loadInfo(id: Int) {
        if (cachedId == id) changeScreenPage(INFO)
        else {
            cachedId = id
            loadComics()
            loadSeries()
            loadStories()
            loadEvents()
            changeScreenPage(INFO)
        }
    }

    fun loadComics() {
        viewModelScope.launch { cachedId?.let { getInfoUseCase.loadComics(it) } }
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

    private fun updateInfo(res: Character) {
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

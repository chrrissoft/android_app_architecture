package com.chrrissoft.marvel.usecases.chars

import com.chrrissoft.marvel.data.chars.CharsRepo
import com.chrrissoft.marvel.data.chars.CharsRepo.Source
import com.chrrissoft.marvel.data.chars.res.charsPrevConverter
import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.usecases.GetBySourceUseCase
import com.chrrissoft.marvel.usecases.GetBySourceUseCase.GetBySource.REMOTE
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCharsPrevUseCase @Inject constructor(
    private val repo: CharsRepo,
    private val getBySourceUseCase: GetBySourceUseCase,
) {

    private var getBySource = REMOTE
    private val _res = MutableStateFlow(CharsPrevRes())
    val res = _res.asStateFlow()

    suspend fun init() {
        withContext(Main) { launch(IO) { getBySourceUseCase.init() } }
        withContext(Main) { launch(IO) { collectGetBySource() } }
    }


    suspend fun getChars() {
        withContext(Main) {
            launch(IO) {
                repo.getChars(Source.REMOTE).collect { res ->
                    _res.update { withContext(Main) { charsPrevConverter(res) } }
                }
            }
        }
    }


    private suspend fun collectGetBySource() {
        getBySourceUseCase.getBySource.collect { getBySource = it }
    }
}
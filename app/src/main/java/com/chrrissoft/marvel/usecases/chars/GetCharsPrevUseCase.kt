package com.chrrissoft.marvel.usecases.chars

import com.chrrissoft.marvel.data.chars.CharsRepo
import com.chrrissoft.marvel.data.chars.CharsRepo.Source.LOCAL
import com.chrrissoft.marvel.data.chars.res.charsPrevConverter
import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
import com.chrrissoft.marvel.usecases.GetBySourceUseCase
import com.chrrissoft.marvel.usecases.GetBySourceUseCase.GetBySource.REMOTE
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.*
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

    suspend operator fun invoke()  {
        withContext(IO) {
            launch { getPreviews() }
        }
    }

    private suspend fun getPreviews() {
        repo.getChars(LOCAL).collect { res ->
            _res.update { charsPrevConverter(res) }
        }
    }

    suspend fun collectGetBySource() {
        withContext(IO) {
            getBySourceUseCase.getBySource.collect { getBySource = it }
        }
    }
}
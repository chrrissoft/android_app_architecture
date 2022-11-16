package com.chrrissoft.marvel.usecases.chars

import com.chrrissoft.marvel.data.chars.CharsRepo
import com.chrrissoft.marvel.usecases.GetBySourceUseCase
import com.chrrissoft.marvel.usecases.GetBySourceUseCase.GetBySource
import com.chrrissoft.marvel.usecases.GetBySourceUseCase.GetBySource.REMOTE
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCharsPrevUseCase @Inject constructor(
    private val repo: CharsRepo,
    private val getBySourceUseCase: GetBySourceUseCase,
) {

    var getBySource: GetBySource = REMOTE

    suspend operator fun invoke() {
        withContext(IO) {
            launch() { getBySourceUseCase() }
            println("after get source ------------------------------")
            launch { updateSource() }
            println("end of function ------------------------------")
        }
    }

    private suspend fun updateSource() {
        getBySourceUseCase.getBySource.collect {
            getBySource = it
        }
    }
}


package com.chrrissoft.marvel.usecases.stories

import com.chrrissoft.marvel.data.stories.StoriesRepo
import com.chrrissoft.marvel.data.stories.res.storiesPrevConverter
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.usecases.GetBySourceUseCase
import com.chrrissoft.marvel.usecases.GetBySourceUseCase.GetBySource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetStoriesPrevUseCase @Inject constructor(
    private val repo: StoriesRepo,
    private val getBySourceUseCase: GetBySourceUseCase,
) {

    private var getBySource = GetBySource.REMOTE
    private val _res = MutableStateFlow(StoriesPrevRes())
    val res = _res.asStateFlow()

    suspend operator fun invoke()  {
        withContext(IO) {
            launch { getPreviews() }
        }
    }

    private suspend fun getPreviews() {
        repo.getPreviews(StoriesRepo.Source.LOCAL).collect { res ->
            _res.update { storiesPrevConverter(res) }
        }
    }

    suspend fun collectGetBySource() {
        withContext(IO) {
            getBySourceUseCase.getBySource.collect { getBySource = it }
        }
    }
}

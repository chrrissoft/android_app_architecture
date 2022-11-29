package com.chrrissoft.marvel.usecases.comics

import com.chrrissoft.marvel.data.comics.ComicsRepo
import com.chrrissoft.marvel.data.comics.ComicsRepo.Source
import com.chrrissoft.marvel.data.comics.res.comicsPrevConverter
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.usecases.GetBySourceUseCase
import com.chrrissoft.marvel.usecases.GetBySourceUseCase.GetBySource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetComicsPrevUseCase @Inject constructor(
    private val repo: ComicsRepo,
    private val getBySourceUseCase: GetBySourceUseCase,
) {

    private var getBySource = GetBySource.REMOTE
    private val _res = MutableStateFlow(ComicsPrevRes())
    val res = _res.asStateFlow()

    suspend operator fun invoke()  {
        withContext(IO) {
            launch { getPreviews() }
        }
    }

    private suspend fun getPreviews() {
        repo.getPreviews(Source.LOCAL).collect { res ->
            _res.update { comicsPrevConverter(res) }
        }
    }

    suspend fun collectGetBySource() {
        withContext(IO) {
            getBySourceUseCase.getBySource.collect { getBySource = it }
        }
    }

}
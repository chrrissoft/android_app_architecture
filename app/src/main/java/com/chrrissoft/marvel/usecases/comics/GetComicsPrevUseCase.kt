package com.chrrissoft.marvel.usecases.comics

import com.chrrissoft.marvel.data.comics.ComicsRepo
import com.chrrissoft.marvel.data.comics.ComicsRepo.Source
import com.chrrissoft.marvel.data.comics.res.comicsPrevConverter
import com.chrrissoft.marvel.ui.comics.res.ComicsPrevRes
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase.DataSource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetComicsPrevUseCase @Inject constructor(
    private val repo: ComicsRepo,
    private val calculateDataSourceUseCase: CalculateDataSourceUseCase,
) {

    private var dataSource = DataSource.REMOTE
    private val _res = MutableStateFlow(ComicsPrevRes())
    val res = _res.asStateFlow()

    suspend fun init() {
        withContext(Main) { launch(IO) { calculateDataSourceUseCase.init() } }
        withContext(Main) { launch(IO) { collectGetBySource() } }
    }

    suspend fun getChars() {
        withContext(Main) {
            launch(IO) {
                repo.getPreviews(Source.REMOTE).collect { res ->
                    _res.update { withContext(Main) { comicsPrevConverter(res) } }
                }
            }
        }
    }

    private suspend fun collectGetBySource() {
        calculateDataSourceUseCase.dataSource.collect {
            withContext(Main) { updateDataSource(it) }
        }
    }

    private fun updateDataSource(result: DataSource) { dataSource = result }

    private fun calculateDataSource(dataSource: DataSource): Source {
        return when (dataSource) {
            DataSource.LOCAL -> Source.LOCAL
            DataSource.REMOTE -> Source.REMOTE
        }
    }

}

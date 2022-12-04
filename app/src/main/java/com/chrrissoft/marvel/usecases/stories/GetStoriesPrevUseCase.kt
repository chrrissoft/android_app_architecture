package com.chrrissoft.marvel.usecases.stories

import com.chrrissoft.marvel.data.stories.StoriesRepo
import com.chrrissoft.marvel.data.stories.StoriesRepo.Source
import com.chrrissoft.marvel.data.stories.res.storiesPrevConverter
import com.chrrissoft.marvel.ui.stories.res.StoriesPrevRes
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase.DataSource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GetStoriesPrevUseCase @Inject constructor(
    private val repo: StoriesRepo,
    private val calculateDataSourceUseCase: CalculateDataSourceUseCase,
) {

    private var dataSource = DataSource.REMOTE
    private val _res = MutableStateFlow(StoriesPrevRes())
    val res = _res.asStateFlow()

    suspend fun init() {
        withContext(Main) { launch(IO) { calculateDataSourceUseCase.init() } }
        withContext(Main) { launch(IO) { collectGetBySource() } }
    }

    suspend fun getChars() {
        withContext(Main) {
            launch(IO) {
                repo.getPreviews(Source.REMOTE).collect { res ->
                    _res.update { withContext(Main) { storiesPrevConverter(res) } }
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

package com.chrrissoft.marvel.usecases.series

import com.chrrissoft.marvel.data.series.SeriesRepo
import com.chrrissoft.marvel.data.series.SeriesRepo.Source
import com.chrrissoft.marvel.data.series.res.seriesPrevConverter
import com.chrrissoft.marvel.ui.series.res.SeriesPrevRes
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase.DataSource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GetSeriesPrevUseCase @Inject constructor(
    private val repo: SeriesRepo,
    private val calculateDataSourceUseCase: CalculateDataSourceUseCase,
) {

    private var dataSource = DataSource.REMOTE
    private val _res = MutableStateFlow(SeriesPrevRes())
    val res = _res.asStateFlow()

    suspend fun init() {
        withContext(Main) { launch(IO) { calculateDataSourceUseCase.init() } }
        withContext(Main) { launch(IO) { collectGetBySource() } }
    }

    suspend fun getChars() {
        withContext(Main) {
            launch(IO) {
                repo.getPreviews(Source.REMOTE).collect { res ->
                    _res.update { withContext(Main) { seriesPrevConverter(res) } }
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

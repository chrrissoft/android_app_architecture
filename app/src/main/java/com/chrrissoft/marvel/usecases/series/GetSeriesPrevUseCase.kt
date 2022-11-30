package com.chrrissoft.marvel.usecases.series

import com.chrrissoft.marvel.data.series.SeriesRepo
import com.chrrissoft.marvel.data.series.SeriesRepo.Source
import com.chrrissoft.marvel.data.series.res.seriesPrevConverter
import com.chrrissoft.marvel.ui.series.res.SeriesPrevRes
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase.DataSource
import kotlinx.coroutines.Dispatchers.IO
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

    suspend operator fun invoke()  {
        withContext(IO) {
            launch { getPreviews() }
        }
    }

    private suspend fun getPreviews() {
        repo.getPreviews(Source.LOCAL).collect { res ->
            _res.update { seriesPrevConverter(res) }
        }
    }

    suspend fun collectGetBySource() {
        withContext(IO) {
            calculateDataSourceUseCase.dataSource.collect { dataSource = it }
        }
    }

}

package com.chrrissoft.marvel.usecases.chars

import com.chrrissoft.marvel.data.chars.CharsRepo
import com.chrrissoft.marvel.data.chars.CharsRepo.Source
import com.chrrissoft.marvel.data.chars.res.charsPrevConverter
import com.chrrissoft.marvel.ui.chars.res.CharsPrevRes
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
class GetCharsPrevUseCase @Inject constructor(
    private val repo: CharsRepo,
    private val calculateDataSourceUseCase: CalculateDataSourceUseCase,
) {

    private var dataSource = DataSource.REMOTE
    private val _res = MutableStateFlow(CharsPrevRes())
    val res = _res.asStateFlow()

    suspend fun init() {
        withContext(Main) { launch(IO) { calculateDataSourceUseCase.init() } }
        withContext(Main) { launch(IO) { collectDataSourceResult() } }
    }

    suspend fun getChars() {
        withContext(Main) {
            launch(IO) {
                repo.getPreviews(Source.REMOTE).collect { res ->
                    _res.update { withContext(Main) { charsPrevConverter(res) } }
                }
            }
        }
    }

    private suspend fun collectDataSourceResult() {
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

package com.chrrissoft.marvel.usecases.events

import com.chrrissoft.marvel.data.events.EventsRepo
import com.chrrissoft.marvel.data.events.EventsRepo.Source
import com.chrrissoft.marvel.data.events.res.eventsPrevConverter
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase.DataSource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GetEventsPrevUseCase @Inject constructor(
    private val repo: EventsRepo,
    private val calculateDataSourceUseCase: CalculateDataSourceUseCase,
) {

    private var dataSource = DataSource.REMOTE
    private val _res = MutableStateFlow(EventsPrevRes())
    val res = _res.asStateFlow()

    suspend fun init() {
        withContext(Main) { launch(IO) { calculateDataSourceUseCase.init() } }
        withContext(Main) { launch(IO) { collectGetBySource() } }
    }

    suspend fun getChars() {
        withContext(Main) {
            launch(IO) {
                repo.getPreviews(Source.REMOTE).collect { res ->
                    _res.update { withContext(Main) { eventsPrevConverter(res) } }
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

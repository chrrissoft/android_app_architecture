package com.chrrissoft.marvel.usecases.events

import com.chrrissoft.marvel.data.events.EventsRepo
import com.chrrissoft.marvel.data.events.EventsRepo.Source
import com.chrrissoft.marvel.data.events.res.eventsPrevConverter
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase.DataSource
import kotlinx.coroutines.Dispatchers.IO
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

    suspend operator fun invoke()  {
        withContext(IO) {
            launch { getPreviews() }
        }
    }

    private suspend fun getPreviews() {
        repo.getPreviews(Source.LOCAL).collect { res ->
            _res.update { eventsPrevConverter(res) }
        }
    }

    suspend fun collectGetBySource() {
        withContext(IO) {
            calculateDataSourceUseCase.dataSource.collect { dataSource = it }
        }
    }

}

package com.chrrissoft.marvel.usecases.series

import com.chrrissoft.marvel.data.series.SeriesRepo
import com.chrrissoft.marvel.data.series.SeriesRepo.RequestOf
import com.chrrissoft.marvel.data.series.SeriesRepo.Source
import com.chrrissoft.marvel.ui.series.Serie
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase.DataSource
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


class GetSerieUseCase @Inject constructor(
    private val repo: SeriesRepo,
    private val calculateDataSourceUseCase: CalculateDataSourceUseCase,
) {

    private var dataSource = DataSource.REMOTE
    private val _res = MutableStateFlow(Serie.emptySerie)
    val res = _res.asStateFlow()

    suspend fun init() {
        withContext(Main) { launch(IO) { calculateDataSourceUseCase.init() } }
        withContext(Main) { launch(IO) { collectDataSourceResult() } }
    }

    suspend fun loadSerie(id: Int) {
        withContext(Main) {
            launch(IO) {
                repo.getInfo(id, RequestOf.SERIE, Source.REMOTE).collect { res ->
                    _res.update { withContext(Main) { res.toUi() } }
                }
            }
        }
    }

    suspend fun loadChars(id: Int) {
        withContext(Main) {
            launch(IO) {
                repo.getInfo(id, RequestOf.CHARS, Source.REMOTE).collect { res ->
                    _res.update { withContext(Main) { res.toUi() } }
                }
            }
        }
    }

    suspend fun loadComics(id: Int) {
        withContext(Main) {
            launch(IO) {
                repo.getInfo(id, RequestOf.COMICS, Source.REMOTE).collect { res ->
                    _res.update { withContext(Main) { res.toUi() } }
                }
            }
        }
    }

    suspend fun loadStories(id: Int) {
        withContext(Main) {
            launch(IO) {
                repo.getInfo(id, RequestOf.STORIES, Source.REMOTE).collect { res ->
                    _res.update { withContext(Main) { res.toUi() } }
                }
            }
        }
    }

    suspend fun loadEvents(id: Int) {
        withContext(Main) {
            launch(IO) {
                repo.getInfo(id, RequestOf.EVENTS, Source.REMOTE).collect { res ->
                    _res.update { withContext(Main) { res.toUi() } }
                }
            }
        }
    }

    private suspend fun collectDataSourceResult() {
        calculateDataSourceUseCase.dataSource.collect {
            coroutineScope { launch(Main) { updateDataSource(it) } }
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

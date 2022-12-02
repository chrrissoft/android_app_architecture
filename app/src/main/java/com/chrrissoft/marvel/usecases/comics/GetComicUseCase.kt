package com.chrrissoft.marvel.usecases.comics

import com.chrrissoft.marvel.data.comics.ComicsRepo
import com.chrrissoft.marvel.data.comics.ComicsRepo.RequestOf
import com.chrrissoft.marvel.data.comics.ComicsRepo.Source
import com.chrrissoft.marvel.ui.comics.Comic
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase.DataSource
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


class GetComicUseCase @Inject constructor(
    private val repo: ComicsRepo,
    private val calculateDataSourceUseCase: CalculateDataSourceUseCase,
) {

    private var dataSource = DataSource.REMOTE
    private val _res = MutableStateFlow(Comic.emptyComic)
    val res = _res.asStateFlow()

    suspend fun init() {
        withContext(Main) { launch(IO) { calculateDataSourceUseCase.init() } }
        withContext(Main) { launch(IO) { collectDataSourceResult() } }
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

    suspend fun loadSeries(id: Int) {
        withContext(Main) {
            launch(IO) {
                repo.getInfo(id, RequestOf.SERIES, Source.REMOTE).collect { res ->
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

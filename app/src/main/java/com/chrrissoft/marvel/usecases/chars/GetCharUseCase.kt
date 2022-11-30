package com.chrrissoft.marvel.usecases.chars

import com.chrrissoft.marvel.data.chars.CharsRepo
import com.chrrissoft.marvel.data.chars.CharsRepo.RequestOf
import com.chrrissoft.marvel.data.chars.CharsRepo.Source
import com.chrrissoft.marvel.ui.chars.Character
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase.DataSource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCharUseCase @Inject constructor(
    private val repo: CharsRepo,
    private val calculateDataSourceUseCase: CalculateDataSourceUseCase,
) {
    private var dataSource = DataSource.REMOTE
    private val _res = MutableStateFlow(Character.emptyChar)
    val res = _res.asStateFlow()

    suspend fun init() {
        withContext(Main) { launch(IO) { calculateDataSourceUseCase.init() } }
        withContext(Main) { launch(IO) { collectGetBySource() } }
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

    private suspend fun collectGetBySource() {
        calculateDataSourceUseCase.dataSource.collect { dataSource = it }
    }

    private fun calculateDataSource(dataSource: DataSource): Source {
        return when (dataSource) {
            DataSource.LOCAL -> Source.LOCAL
            DataSource.REMOTE -> Source.REMOTE
        }
    }
}


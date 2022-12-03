package com.chrrissoft.marvel.usecases.stories

import com.chrrissoft.marvel.data.stories.StoriesRepo
import com.chrrissoft.marvel.data.stories.StoriesRepo.RequestOf
import com.chrrissoft.marvel.data.stories.StoriesRepo.Source
import com.chrrissoft.marvel.ui.stories.Story
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase.DataSource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GetStoryUseCase @Inject constructor(
    private val repo: StoriesRepo,
    private val calculateDataSourceUseCase: CalculateDataSourceUseCase,
) {

    private var dataSource = DataSource.REMOTE
    private val _res = MutableStateFlow(Story.emptyStory)
    val res = _res.asStateFlow()

    suspend fun init() {
        withContext(Main) { launch(IO) { calculateDataSourceUseCase.init() } }
        withContext(Main) { launch(IO) { collectDataSourceResult() } }
    }

    suspend fun loadStory(id: Int) {
        withContext(Main) {
            launch(IO) {
                repo.getInfo(id, RequestOf.STORY, Source.REMOTE).collect { res ->
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

    suspend fun loadSeries(id: Int) {
        withContext(Main) {
            launch(IO) {
                repo.getInfo(id, RequestOf.SERIES, Source.REMOTE).collect { res ->
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

    private fun updateDataSource(result: DataSource) {
        dataSource = result
    }

    private fun calculateDataSource(dataSource: DataSource): Source {
        return when (dataSource) {
            DataSource.LOCAL -> Source.LOCAL
            DataSource.REMOTE -> Source.REMOTE
        }
    }
}

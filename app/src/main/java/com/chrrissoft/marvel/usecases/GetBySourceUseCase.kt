package com.chrrissoft.marvel.usecases

import com.chrrissoft.marvel.data.netstate.NetObserver
import com.chrrissoft.marvel.data.netstate.NetState
import com.chrrissoft.marvel.data.netstate.NetState.*
import com.chrrissoft.marvel.usecases.GetBySourceUseCase.GetBySource.LOCAL
import com.chrrissoft.marvel.usecases.GetBySourceUseCase.GetBySource.REMOTE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBySourceUseCase @Inject constructor(
    private val netObserver: NetObserver
) {

    private val _getBySource = MutableStateFlow(REMOTE)
    val getBySource = _getBySource.asStateFlow()

    enum class GetBySource { LOCAL, REMOTE }

    suspend operator fun invoke() =
        withContext(IO) { observer() }

    private fun CoroutineScope.observer() {
        launch() {
            netObserver.observe().collect { update(it) }
        }
    }

    private fun update(observerResult: NetState) {
        _getBySource.update {
            when(observerResult) {
                Unavailable -> LOCAL
                Available -> REMOTE
                Lost -> LOCAL
            }
        }
    }
}
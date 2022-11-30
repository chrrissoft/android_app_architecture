package com.chrrissoft.marvel.usecases

import com.chrrissoft.marvel.data.netstate.NetObserver
import com.chrrissoft.marvel.data.netstate.NetState
import com.chrrissoft.marvel.data.netstate.NetState.*
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase.DataSource.LOCAL
import com.chrrissoft.marvel.usecases.CalculateDataSourceUseCase.DataSource.REMOTE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class CalculateDataSourceUseCase @Inject constructor(
    private val netObserver: NetObserver
) {

    private val _dataSource = MutableStateFlow(REMOTE)
    val dataSource = _dataSource.asStateFlow()

    enum class DataSource { LOCAL, REMOTE }

    suspend fun init() = observer()

    private suspend fun observer() {
        netObserver.observe().collect { update(it) }
    }

    private fun update(observerResult: NetState) {
        _dataSource.update {
            when (observerResult) {
                Lost -> LOCAL
                Available -> REMOTE
                Unavailable -> LOCAL
            }
        }
    }
}
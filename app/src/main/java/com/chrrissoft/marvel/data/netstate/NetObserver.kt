package com.chrrissoft.marvel.data.netstate

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface NetObserver {
    fun observe(): Flow<NetState>
}

package com.chrrissoft.marvel.data.netstate

import kotlinx.coroutines.flow.Flow

interface NetObserver {
    fun observe(): Flow<NetState>
}

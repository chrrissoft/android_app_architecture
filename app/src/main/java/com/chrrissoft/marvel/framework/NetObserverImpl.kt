package com.chrrissoft.marvel.framework


import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import com.chrrissoft.marvel.MarvelApp
import com.chrrissoft.marvel.data.netstate.NetObserver
import com.chrrissoft.marvel.data.netstate.NetState
import com.chrrissoft.marvel.data.netstate.NetState.*
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetObserverImpl @Inject constructor(
    @ApplicationContext val context: Context
) : NetObserver {

    private val connectivityManager = context.applicationContext
        .getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun observe(): Flow<NetState> {
        return callbackFlow {
            val callback = object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    launch { send(Available) }
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    launch { send(Lost) }
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    launch { send(Unavailable) }
                }
            }

            connectivityManager.registerDefaultNetworkCallback(callback)

            awaitClose {
                connectivityManager.unregisterNetworkCallback(callback)
            }
        }.distinctUntilChanged()
    }
}
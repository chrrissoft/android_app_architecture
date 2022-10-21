package com.chrrissoft.marvel.di

import com.chrrissoft.marvel.data.netstate.NetObserver
import com.chrrissoft.marvel.framework.NetObserverImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetObserverModule {

    @Binds
    abstract fun provideNetObserver(
        observer: NetObserverImpl
    ) : NetObserver

}
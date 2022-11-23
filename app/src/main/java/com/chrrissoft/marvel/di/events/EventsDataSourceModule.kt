package com.chrrissoft.marvel.di.events

import com.chrrissoft.marvel.data.events.EventsDataSource.LocalEventsDataSource
import com.chrrissoft.marvel.data.events.EventsDataSource.RemoteEventsDataSource
import com.chrrissoft.marvel.framework.events.datasource.LocalEventsDataSourceImpl
import com.chrrissoft.marvel.framework.events.datasource.RemoteEventsDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class EventsDataSourceModule {

    @Binds
    abstract fun provideLocalDataSource(
        local: LocalEventsDataSourceImpl
    ) : LocalEventsDataSource

    @Binds
    abstract fun provideRemoteDataSource(
        remote: RemoteEventsDataSourceImp
    ) : RemoteEventsDataSource
}
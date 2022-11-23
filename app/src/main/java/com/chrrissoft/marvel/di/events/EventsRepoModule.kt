package com.chrrissoft.marvel.di.events

import com.chrrissoft.marvel.data.events.EventsRepo
import com.chrrissoft.marvel.framework.events.EventsRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class EventsRepoModule {

    @Binds
    abstract fun provideRepo(repo: EventsRepoImpl): EventsRepo

}
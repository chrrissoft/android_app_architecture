package com.chrrissoft.marvel.di.events

import com.chrrissoft.marvel.framework.events.api.EventsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class EventsAPIModule {

    @Singleton
    @Provides
    fun provideAPI(retrofit: Retrofit): EventsAPIService =
        retrofit.create(EventsAPIService::class.java)

}
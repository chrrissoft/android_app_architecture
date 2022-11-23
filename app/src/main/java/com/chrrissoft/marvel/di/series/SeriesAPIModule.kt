package com.chrrissoft.marvel.di.series

import com.chrrissoft.marvel.framework.series.api.SeriesAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SeriesAPIModule {

    @Singleton
    @Provides
    fun provideAPI(retrofit: Retrofit): SeriesAPIService =
        retrofit.create(SeriesAPIService::class.java)

}


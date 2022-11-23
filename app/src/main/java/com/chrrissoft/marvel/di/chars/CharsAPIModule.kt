package com.chrrissoft.marvel.di.chars

import com.chrrissoft.marvel.framework.chars.api.CharsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CharsAPIModule {

    @Singleton
    @Provides
    fun provideAPI(retrofit: Retrofit): CharsAPIService =
        retrofit.create(CharsAPIService::class.java)

}


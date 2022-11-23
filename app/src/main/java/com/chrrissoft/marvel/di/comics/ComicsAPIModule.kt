package com.chrrissoft.marvel.di.comics

import com.chrrissoft.marvel.framework.comics.api.ComicsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ComicsAPIModule {

    @Singleton
    @Provides
    fun provideAPI(retrofit: Retrofit): ComicsAPIService =
        retrofit.create(ComicsAPIService::class.java)

}


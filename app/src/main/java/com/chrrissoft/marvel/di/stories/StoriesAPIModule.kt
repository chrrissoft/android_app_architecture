package com.chrrissoft.marvel.di.stories

import com.chrrissoft.marvel.framework.stories.api.StoriesAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StoriesAPIModule {

    @Singleton
    @Provides
    fun provideAPI(retrofit: Retrofit): StoriesAPIService =
        retrofit.create(StoriesAPIService::class.java)

}
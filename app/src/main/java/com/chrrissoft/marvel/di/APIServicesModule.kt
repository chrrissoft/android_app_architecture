package com.chrrissoft.marvel.di

import com.chrrissoft.marvel.framework.chars.api.CharacterAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class APIServicesModule {

    @Singleton
    @Provides
    fun provideCharactersAPI(retrofit: Retrofit): CharacterAPIService =
        retrofit.create(CharacterAPIService::class.java)

}
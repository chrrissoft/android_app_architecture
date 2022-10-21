package com.chrrissoft.marvel.di

import com.chrrissoft.marvel.MarvelApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideMarvelApp() : MarvelApp = MarvelApp()

}
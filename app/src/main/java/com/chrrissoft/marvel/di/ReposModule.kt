package com.chrrissoft.marvel.di

import com.chrrissoft.marvel.data.characters.CharactersRepo
import com.chrrissoft.marvel.framework.characters.CharacterRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ReposModule {

    @Binds
    abstract fun provideRepo(repo: CharacterRepoImpl): CharactersRepo
}


package com.chrrissoft.marvel.di

import com.chrrissoft.marvel.data.chars.CharacterDataSource
import com.chrrissoft.marvel.framework.chars.datasource.LocalCharacterDataSourceImpl
import com.chrrissoft.marvel.framework.chars.datasource.RemoteCharacterDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CharactersDataSourceModule {

    @Binds
    abstract fun provideLocalDataSource(
        local: LocalCharacterDataSourceImpl
    ) : CharacterDataSource

    @Binds
    abstract fun provideRemoteDataSource(
        remote: RemoteCharacterDataSourceImp
    ) : CharacterDataSource
}
package com.chrrissoft.marvel.di

import com.chrrissoft.marvel.data.characters.CharacterDataSource.LocalCharacterDataSource
import com.chrrissoft.marvel.data.characters.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.framework.characters.datasource.LocalCharacterDataSourceImpl
import com.chrrissoft.marvel.framework.characters.datasource.RemoteCharacterDataSourceImp
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
    ) : LocalCharacterDataSource

    @Binds
    abstract fun provideRemoteDataSource(
        remote: RemoteCharacterDataSourceImp
    ) : RemoteCharacterDataSource
}
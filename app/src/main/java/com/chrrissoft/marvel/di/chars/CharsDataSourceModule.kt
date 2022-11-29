package com.chrrissoft.marvel.di.chars

import com.chrrissoft.marvel.data.chars.CharacterDataSource.LocalCharacterDataSource
import com.chrrissoft.marvel.data.chars.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.framework.chars.datasource.LocalCharacterDataSourceImpl
import com.chrrissoft.marvel.framework.chars.datasource.RemoteCharsDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CharsDataSourceModule {

    @Binds
    abstract fun provideLocalDataSource(
        local: LocalCharacterDataSourceImpl
    ) : LocalCharacterDataSource

    @Binds
    abstract fun provideRemoteDataSource(
        remote: RemoteCharsDataSourceImp
    ) : RemoteCharacterDataSource
}

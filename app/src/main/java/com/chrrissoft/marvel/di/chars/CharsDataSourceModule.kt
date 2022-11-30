package com.chrrissoft.marvel.di.chars

import com.chrrissoft.marvel.data.chars.CharsDataSource.LocalCharsDataSource
import com.chrrissoft.marvel.data.chars.CharsDataSource.RemoteCharsDataSource
import com.chrrissoft.marvel.framework.chars.datasource.LocalCharsDataSourceImpl
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
        local: LocalCharsDataSourceImpl
    ) : LocalCharsDataSource

    @Binds
    abstract fun provideRemoteDataSource(
        remote: RemoteCharsDataSourceImp
    ) : RemoteCharsDataSource
}

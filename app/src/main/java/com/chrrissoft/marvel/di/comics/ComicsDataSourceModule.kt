package com.chrrissoft.marvel.di.comics

import com.chrrissoft.marvel.data.comics.ComicsDataSource.LocalComicsDataSource
import com.chrrissoft.marvel.data.comics.ComicsDataSource.RemoteComicsDataSource
import com.chrrissoft.marvel.framework.comics.datasource.LocalComicsDataSourceImpl
import com.chrrissoft.marvel.framework.comics.datasource.RemoteComicsDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ComicsDataSourceModule {

    @Binds
    abstract fun provideLocalDataSource(
        local: LocalComicsDataSourceImpl
    ) : LocalComicsDataSource

    @Binds
    abstract fun provideRemoteDataSource(
        remote: RemoteComicsDataSourceImp
    ) : RemoteComicsDataSource
}
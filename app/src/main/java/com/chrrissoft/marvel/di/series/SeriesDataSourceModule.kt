package com.chrrissoft.marvel.di.series

import com.chrrissoft.marvel.data.series.SeriesDataSource.LocalSeriesDataSource
import com.chrrissoft.marvel.data.series.SeriesDataSource.RemoteSeriesDataSource
import com.chrrissoft.marvel.framework.series.datasource.LocalSeriesDataSourceImpl
import com.chrrissoft.marvel.framework.series.datasource.RemoteSeriesDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SeriesDataSourceModule {

    @Binds
    abstract fun provideLocalDataSource(
        local: LocalSeriesDataSourceImpl
    ) : LocalSeriesDataSource

    @Binds
    abstract fun provideRemoteDataSource(
        remote: RemoteSeriesDataSourceImp
    ) : RemoteSeriesDataSource
}
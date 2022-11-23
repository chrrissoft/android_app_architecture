package com.chrrissoft.marvel.di.series

import com.chrrissoft.marvel.data.series.SeriesRepo
import com.chrrissoft.marvel.framework.series.SeriesRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SeriesRepoModule {

    @Binds
    abstract fun provideRepo(repo: SeriesRepoImpl): SeriesRepo

}
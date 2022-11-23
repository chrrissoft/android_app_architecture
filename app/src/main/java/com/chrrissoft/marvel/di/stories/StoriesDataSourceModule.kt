package com.chrrissoft.marvel.di.stories

import com.chrrissoft.marvel.data.stories.StoriesDataSource.LocalStoriesDataSource
import com.chrrissoft.marvel.data.stories.StoriesDataSource.RemoteStoriesDataSource
import com.chrrissoft.marvel.framework.stories.datasource.LocalStoriesDataSourceImpl
import com.chrrissoft.marvel.framework.stories.datasource.RemoteStoriesDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StoriesDataSourceModule {

    @Binds
    abstract fun provideLocalDataSource(
        local: LocalStoriesDataSourceImpl
    ) : LocalStoriesDataSource

    @Binds
    abstract fun provideRemoteDataSource(
        remote: RemoteStoriesDataSourceImp
    ) : RemoteStoriesDataSource
}
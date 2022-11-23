package com.chrrissoft.marvel.di.stories

import com.chrrissoft.marvel.data.stories.StoriesRepo
import com.chrrissoft.marvel.framework.stories.StoriesRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StoriesRepoModule {

    @Binds
    abstract fun provideRepo(repo: StoriesRepoImpl): StoriesRepo

}


package com.chrrissoft.marvel.di.comics

import com.chrrissoft.marvel.data.comics.ComicsRepo
import com.chrrissoft.marvel.framework.comics.ComicsRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ComicsRepoModule {

    @Binds
    abstract fun provideRepo(repo: ComicsRepoImpl): ComicsRepo

}


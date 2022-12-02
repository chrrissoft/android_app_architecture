package com.chrrissoft.marvel.di.chars

import com.chrrissoft.marvel.data.chars.CharsRepo
import com.chrrissoft.marvel.framework.chars.CharsRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CharsRepoModule {

    @Binds
    abstract fun provideRepo(repo: CharsRepoImpl): CharsRepo

}

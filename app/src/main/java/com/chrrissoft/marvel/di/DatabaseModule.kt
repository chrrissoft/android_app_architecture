package com.chrrissoft.marvel.di

import androidx.room.Room
import com.chrrissoft.marvel.MarvelApp
import com.chrrissoft.marvel.framework.Database
import com.chrrissoft.marvel.framework.chars.db.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    companion object {
        private const val DATABASE_NAME = "marvel"
    }

    @Singleton
    @Provides
    fun provideMarvelDatabase(
        @ApplicationContext app: MarvelApp
    ) = Room.databaseBuilder(
        app, Database::class.java, DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideCharactersDao(db: Database): CharacterDao = db.characterDao()
}

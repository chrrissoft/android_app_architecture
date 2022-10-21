package com.chrrissoft.marvel.di

import android.content.Context
import androidx.room.Room
import com.chrrissoft.marvel.framework.characters.database.info.CharacterInfoDao
import com.chrrissoft.marvel.framework.characters.database.preview.CharacterPreviewDao
import com.chrrissoft.marvel.framework.Database
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
        const val DATABASE_NAME = "marvel"
    }

    @Singleton
    @Provides
    fun provideMarvelDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app, Database::class.java, DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideCharactersPrevDao(db: Database): CharacterPreviewDao = db.characterPrevDao()

    @Singleton
    @Provides
    fun provideCharactersInfoDao(db: Database): CharacterInfoDao = db.characterInfoDao()
}
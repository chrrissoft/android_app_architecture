package com.chrrissoft.marvel.framework

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chrrissoft.marvel.framework.characters.database.info.CharacterInfo
import com.chrrissoft.marvel.framework.characters.database.info.CharacterInfoDao
import com.chrrissoft.marvel.framework.characters.database.preview.CharacterPreview
import com.chrrissoft.marvel.framework.characters.database.preview.CharacterPreviewDao

@Database(
    entities = [
        CharacterPreview::class,
        CharacterInfo::class
    ], version = 1
)
abstract class Database : RoomDatabase() {
    abstract fun characterPrevDao(): CharacterPreviewDao
    abstract fun characterInfoDao(): CharacterInfoDao
}
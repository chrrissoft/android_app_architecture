package com.chrrissoft.marvel.framework

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chrrissoft.marvel.framework.characters.db.CharacterDao

@Database(
    entities = [], version = 1
)
abstract class Database : RoomDatabase() {
    abstract fun characterDao() : CharacterDao
}
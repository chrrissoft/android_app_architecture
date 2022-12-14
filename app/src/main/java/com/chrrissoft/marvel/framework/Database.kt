package com.chrrissoft.marvel.framework

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chrrissoft.marvel.framework.chars.db.CharacterDao
import com.chrrissoft.marvel.framework.chars.db.Characters
import com.chrrissoft.marvel.framework.db.converters.*

@Database(
    entities = [
        Characters::class, /*Comics::class,
        Series::class, Stories::class, Events::class,*/
    ], version = 1
)

@TypeConverters(
//    CharsConverter::class,
    ComicsConverter::class,
/*    SeriesConverter::class,
    EventsConverter::class,
    StoriesConverter::class,*/
)
abstract class Database : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
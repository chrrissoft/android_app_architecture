package com.chrrissoft.marvel.framework

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chrrissoft.marvel.framework.chars.db.CharacterDao
import com.chrrissoft.marvel.framework.chars.db.Characters
import com.chrrissoft.marvel.framework.comics.db.Comics
import com.chrrissoft.marvel.framework.db.converters.*
import com.chrrissoft.marvel.framework.events.db.Events
import com.chrrissoft.marvel.framework.series.db.Series
import com.chrrissoft.marvel.framework.stories.db.Stories

@Database(
    entities = [
        Series::class, Characters::class, Comics::class, Events::class, Stories::class
    ], version = 1
)
@TypeConverters(
    CharsConverter::class,
    BitmapConverter::class,
    ComicsConverter::class,
    SeriesConverter::class,
    EventsConverter::class,
    StoriesConverter::class,
)
abstract class Database : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
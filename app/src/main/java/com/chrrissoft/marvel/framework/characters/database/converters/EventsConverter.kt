package com.chrrissoft.marvel.framework.characters.database.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.characters.database.info.Events

class EventsConverter {

    @TypeConverter
    fun fromComics(bitmap: Events): String {
        return bitmap.toString()
    }

    @TypeConverter
    fun toComics(byteArray: String): Events {
        return Events()
    }

}
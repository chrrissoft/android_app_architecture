package com.chrrissoft.marvel.framework.characters.database.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.characters.database.info.Comics

class ComicsConverter {

    @TypeConverter
    fun fromComics(bitmap: Comics): String {
        return bitmap.toString()
    }

    @TypeConverter
    fun toComics(byteArray: String): Comics {
        return Comics()
    }

}


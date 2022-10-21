package com.chrrissoft.marvel.framework.characters.database.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.characters.database.info.Stories

class StoriesConverter {

    @TypeConverter
    fun fromComics(bitmap: Stories): String {
        return bitmap.toString()
    }

    @TypeConverter
    fun toComics(byteArray: String): Stories {
        return Stories()
    }

}


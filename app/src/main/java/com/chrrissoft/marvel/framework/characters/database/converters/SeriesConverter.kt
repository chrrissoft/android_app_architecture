package com.chrrissoft.marvel.framework.characters.database.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.characters.database.info.Series

class SeriesConverter {

    @TypeConverter
    fun fromComics(bitmap: Series): String {
        return bitmap.toString()
    }

    @TypeConverter
    fun toComics(byteArray: String): Series {
        return Series()
    }

}


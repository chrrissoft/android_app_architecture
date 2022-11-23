package com.chrrissoft.marvel.framework.db.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.db.SeriesPreview
import com.chrrissoft.marvel.framework.db.myFromJson
import com.google.gson.Gson

class SeriesConverter {
    @TypeConverter
    fun fromJson(json: String) : List<SeriesPreview> {
        val gson = Gson()
        return gson.myFromJson<List<SeriesPreview>>(json)
    }

    @TypeConverter
    fun toJson(json: List<SeriesPreview>) : String {
        val gson = Gson()
        return gson.toJson(json, SeriesPreview::class.java)
    }
}
package com.chrrissoft.marvel.framework.db.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.db.ComicPreview
import com.chrrissoft.marvel.framework.db.myFromJson
import com.google.gson.Gson

class ComicsConverter {

    @TypeConverter
    fun fromJson(json: String): List<ComicPreview> {
        val gson = Gson()
        return gson.myFromJson<List<ComicPreview>>(json)
    }

    @TypeConverter
    fun toJson(json: List<ComicPreview>): String {
        val gson = Gson()
        return gson.toJson(json)
    }

}


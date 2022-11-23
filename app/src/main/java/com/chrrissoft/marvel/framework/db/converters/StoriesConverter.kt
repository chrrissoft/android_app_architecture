package com.chrrissoft.marvel.framework.db.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.db.StoriesPreview
import com.chrrissoft.marvel.framework.db.myFromJson
import com.google.gson.Gson

class StoriesConverter {
    @TypeConverter
    fun fromJson(json: String) : List<StoriesPreview> {
        val gson = Gson()
        return gson.myFromJson<List<StoriesPreview>>(json)
    }

    @TypeConverter
    fun toJson(json: List<StoriesPreview>) : String {
        val gson = Gson()
        return gson.toJson(json, StoriesPreview::class.java)
    }
}
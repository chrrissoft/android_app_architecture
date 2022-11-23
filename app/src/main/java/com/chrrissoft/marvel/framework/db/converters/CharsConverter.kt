package com.chrrissoft.marvel.framework.db.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.db.CharacterPreview
import com.chrrissoft.marvel.framework.db.myFromJson
import com.google.gson.Gson

class CharsConverter {
    @TypeConverter
    fun fromJson(json: String) : List<CharacterPreview> {
        val gson = Gson()
        return gson.myFromJson<List<CharacterPreview>>(json)
    }

    @TypeConverter
    fun toJson(json: List<CharacterPreview>) : String {
        val gson = Gson()
        return gson.toJson(json, CharacterPreview::class.java)
    }
}
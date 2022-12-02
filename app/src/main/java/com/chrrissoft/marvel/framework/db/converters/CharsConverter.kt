package com.chrrissoft.marvel.framework.db.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.db.CharacterPreview
import com.chrrissoft.marvel.framework.db.CharacterPreview.Companion.serializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class CharsConverter {
    @TypeConverter
    fun fromJson(json: String) : List<CharacterPreview> {
        val gson = Json
        return gson.decodeFromString(ListSerializer(serializer()), json)
    }

    @TypeConverter
    fun toJson(json: List<CharacterPreview>) : String {
        val gson = Json
        return gson.encodeToString(ListSerializer(serializer()), json)
    }
}
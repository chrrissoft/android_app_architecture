package com.chrrissoft.marvel.framework.db.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.db.ComicPreview
import kotlinx.serialization.json.Json

class ComicsConverter {

/*    @TypeConverter
    fun fromJson(json: String): List<ComicPreview> {
        val gson = Json
        return gson.decodeFromString(ListSerializer(ComicPreview.serializer()), json)
    }

    @TypeConverter
    fun toJson(json: List<ComicPreview>): String {
        val gson = Json
        return gson.encodeToString(ListSerializer(ComicPreview.serializer()), json)
    }*/

    @TypeConverter
    fun fromJson(json: String): ComicPreview {
        val gson = Json
        return gson.decodeFromString(ComicPreview.serializer(), json)
    }

    @TypeConverter
    fun toJson(json: ComicPreview): String {
        val gson = Json
        return gson.encodeToString(ComicPreview.serializer(), json)
    }

}


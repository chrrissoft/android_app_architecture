package com.chrrissoft.marvel.framework.db.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.db.StoriesPreview
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class StoriesConverter {
    @TypeConverter
    fun fromJson(json: String) : List<StoriesPreview> {
        val gson = Json
        return gson.decodeFromString(ListSerializer(StoriesPreview.serializer()), json)
    }

    @TypeConverter
    fun toJson(json: List<StoriesPreview>) : String {
        val gson = Json
        return gson.encodeToString(ListSerializer(StoriesPreview.serializer()), json)
    }
}
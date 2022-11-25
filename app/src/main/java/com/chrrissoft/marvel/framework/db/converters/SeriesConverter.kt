package com.chrrissoft.marvel.framework.db.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.db.SeriesPreview
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class SeriesConverter {
    @TypeConverter
    fun fromJson(json: String) : List<SeriesPreview> {
        val gson = Json
        return gson.decodeFromString(ListSerializer(SeriesPreview.serializer()), json)
    }

    @TypeConverter
    fun toJson(json: List<SeriesPreview>) : String {
        val gson = Json
        return gson.encodeToString(ListSerializer(SeriesPreview.serializer()), json)
    }
}
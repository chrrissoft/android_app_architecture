package com.chrrissoft.marvel.framework.db.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.db.EventPreview
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class EventsConverter {
    @TypeConverter
    fun fromJson(json: String) : List<EventPreview> {
        val gson = Json
        return gson.decodeFromString(ListSerializer(EventPreview.serializer()), json)
    }

    @TypeConverter
    fun toJson(json: List<EventPreview>) : String {
        val gson = Json
        return gson.encodeToString(ListSerializer(EventPreview.serializer()), json)
    }
}
package com.chrrissoft.marvel.framework.db.converters

import androidx.room.TypeConverter
import com.chrrissoft.marvel.framework.db.EventPreview
import com.chrrissoft.marvel.framework.db.myFromJson
import com.google.gson.Gson

class EventsConverter {
    @TypeConverter
    fun fromJson(json: String) : List<EventPreview> {
        val gson = Gson()
        return gson.myFromJson<List<EventPreview>>(json)
    }

    @TypeConverter
    fun toJson(json: List<EventPreview>) : String {
        val gson = Gson()
        return gson.toJson(json, EventPreview::class.java)
    }
}
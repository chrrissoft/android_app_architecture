package com.chrrissoft.marvel.framework.events.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chrrissoft.marvel.framework.common.*
import com.chrrissoft.marvel.framework.events.db.Events.Companion.EVENTS_TABLE

@Entity(tableName = EVENTS_TABLE)
data class Events(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image") val image: Any,
    @ColumnInfo(name = "events") val series: List<SeriesPreview>,
    @ColumnInfo(name = "comics") val comics: List<ComicPreview>,
    @ColumnInfo(name = "stories") val stories: List<StoriesPreview>,
    @ColumnInfo(name = "characters") val characters: List<CharacterPreview>,
) {
    companion object {
        internal const val EVENTS_TABLE = "events_table"
    }
}
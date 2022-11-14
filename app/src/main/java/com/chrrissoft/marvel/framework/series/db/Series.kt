package com.chrrissoft.marvel.framework.series.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chrrissoft.marvel.framework.common.*
import com.chrrissoft.marvel.framework.series.db.Series.Companion.SERIES_TABLE

@Entity(tableName = SERIES_TABLE)
data class Series(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image") val image: Any,
    @ColumnInfo(name = "events") val events: List<EventPreview>,
    @ColumnInfo(name = "events") val comics: List<ComicPreview>,
    @ColumnInfo(name = "stories") val stories: List<StoriesPreview>,
    @ColumnInfo(name = "characters") val characters: List<CharacterPreview>,
) {
    companion object {
        internal const val SERIES_TABLE = "series_table"
    }
}
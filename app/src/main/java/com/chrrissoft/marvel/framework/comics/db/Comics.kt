package com.chrrissoft.marvel.framework.comics.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chrrissoft.marvel.framework.comics.db.Comics.Companion.COMICS_TABLE
import com.chrrissoft.marvel.framework.common.*

@Entity(tableName = COMICS_TABLE)
data class Comics(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image") val image: Any,
    @ColumnInfo(name = "events") val events: List<EventPreview>,
    @ColumnInfo(name = "series") val series: List<SeriesPreview>,
    @ColumnInfo(name = "stories") val stories: List<StoriesPreview>,
    @ColumnInfo(name = "series") val characters: List<CharacterPreview>,
) {
    internal companion object {
        const val COMICS_TABLE = "characters_table"
    }
}
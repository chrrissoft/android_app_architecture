package com.chrrissoft.marvel.framework.stories.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chrrissoft.marvel.framework.common.*
import com.chrrissoft.marvel.framework.stories.db.Stories.Companion.STORIES_TABLE

@Entity(tableName = STORIES_TABLE)
data class Stories(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image") val image: Any,
    @ColumnInfo(name = "events") val events: List<EventPreview>,
    @ColumnInfo(name = "comics") val comics: List<ComicPreview>,
    @ColumnInfo(name = "series") val series: List<SeriesPreview>,
    @ColumnInfo(name = "characters") val characters: List<CharacterPreview>,
) {
    internal companion object {
        const val STORIES_TABLE = "stories_table"
    }
}
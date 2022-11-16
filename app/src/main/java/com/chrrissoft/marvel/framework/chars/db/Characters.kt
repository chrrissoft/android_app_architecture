package com.chrrissoft.marvel.framework.chars.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.chrrissoft.marvel.framework.chars.db.Characters.Companion.CHARACTER_TABLE
import com.chrrissoft.marvel.framework.common.ComicPreview
import com.chrrissoft.marvel.framework.common.EventPreview
import com.chrrissoft.marvel.framework.common.SeriesPreview
import com.chrrissoft.marvel.framework.common.StoriesPreview

@Entity(tableName = CHARACTER_TABLE)
data class Characters(
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: Any,
    @ColumnInfo(name = "comics") val comics: List<ComicPreview>,
    @ColumnInfo(name = "series") val series: List<SeriesPreview>,
    @ColumnInfo(name = "events") val events: List<EventPreview>,
    @ColumnInfo(name = "stories") val stories: List<StoriesPreview>
) {
    companion object {
        const val CHARACTER_TABLE = "characters_table"
    }
}
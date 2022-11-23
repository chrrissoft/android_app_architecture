package com.chrrissoft.marvel.framework.chars.db

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chrrissoft.marvel.framework.chars.db.Characters.Companion.CHARACTER_TABLE
import com.chrrissoft.marvel.framework.db.ComicPreview
import com.chrrissoft.marvel.framework.db.EventPreview
import com.chrrissoft.marvel.framework.db.SeriesPreview
import com.chrrissoft.marvel.framework.db.StoriesPreview

@Entity(tableName = CHARACTER_TABLE)
data class Characters(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: Bitmap,
    @ColumnInfo(name = "comics") val comics: List<ComicPreview>,
    @ColumnInfo(name = "series") val series: List<SeriesPreview>,
    @ColumnInfo(name = "events") val events: List<EventPreview>,
    @ColumnInfo(name = "stories") val stories: List<StoriesPreview>
) {
    companion object {
        const val CHARACTER_TABLE = "characters_table"
    }
}
package com.chrrissoft.marvel.framework.stories.db

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chrrissoft.marvel.framework.db.CharacterPreview
import com.chrrissoft.marvel.framework.db.ComicPreview
import com.chrrissoft.marvel.framework.db.EventPreview
import com.chrrissoft.marvel.framework.db.SeriesPreview
import com.chrrissoft.marvel.framework.stories.db.Stories.Companion.STORIES_TABLE

@Entity(tableName = STORIES_TABLE)
data class Stories(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image") val image: Bitmap,
    @ColumnInfo(name = "events") val events: List<EventPreview>,
    @ColumnInfo(name = "comics") val comics: List<ComicPreview>,
    @ColumnInfo(name = "series") val series: List<SeriesPreview>,
    @ColumnInfo(name = "characters") val characters: List<CharacterPreview>,
) {
    internal companion object {
        const val STORIES_TABLE = "stories_table"
    }
}
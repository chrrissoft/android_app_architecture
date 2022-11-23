package com.chrrissoft.marvel.framework.events.db

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chrrissoft.marvel.framework.db.CharacterPreview
import com.chrrissoft.marvel.framework.db.ComicPreview
import com.chrrissoft.marvel.framework.db.SeriesPreview
import com.chrrissoft.marvel.framework.db.StoriesPreview
import com.chrrissoft.marvel.framework.events.db.Events.Companion.EVENTS_TABLE

@Entity(tableName = EVENTS_TABLE)
data class Events(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image") val image: Bitmap,
    @ColumnInfo(name = "series") val series: List<SeriesPreview>,
    @ColumnInfo(name = "comics") val comics: List<ComicPreview>,
    @ColumnInfo(name = "stories") val stories: List<StoriesPreview>,
    @ColumnInfo(name = "characters") val characters: List<CharacterPreview>,
) {
    companion object {
        internal const val EVENTS_TABLE = "events_table"
    }
}
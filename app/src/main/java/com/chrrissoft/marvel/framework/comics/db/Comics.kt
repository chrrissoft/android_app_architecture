package com.chrrissoft.marvel.framework.comics.db

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chrrissoft.marvel.framework.comics.db.Comics.Companion.COMICS_TABLE
import com.chrrissoft.marvel.framework.db.CharacterPreview
import com.chrrissoft.marvel.framework.db.EventPreview
import com.chrrissoft.marvel.framework.db.SeriesPreview
import com.chrrissoft.marvel.framework.db.StoriesPreview

@Entity(tableName = COMICS_TABLE)
data class Comics(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image") val image: Bitmap,
    @ColumnInfo(name = "events") val events: List<EventPreview>,
    @ColumnInfo(name = "series") val series: List<SeriesPreview>,
    @ColumnInfo(name = "stories") val stories: List<StoriesPreview>,
    @ColumnInfo(name = "characters") val characters: List<CharacterPreview>,
) {
    companion object {
        internal const val COMICS_TABLE = "comics_table"
    }
}
package com.chrrissoft.marvel.framework.stories.db

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
    @ColumnInfo(name = "image") val image: ByteArray,
    @ColumnInfo(name = "events") val events: List<EventPreview>,
    @ColumnInfo(name = "comics") val comics: List<ComicPreview>,
    @ColumnInfo(name = "series") val series: List<SeriesPreview>,
    @ColumnInfo(name = "characters") val characters: List<CharacterPreview>,
) {
    internal companion object {
        const val STORIES_TABLE = "stories_table"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Stories

        if (id != other.id) return false
        if (title != other.title) return false
        if (!image.contentEquals(other.image)) return false
        if (events != other.events) return false
        if (comics != other.comics) return false
        if (series != other.series) return false
        if (characters != other.characters) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + image.contentHashCode()
        result = 31 * result + events.hashCode()
        result = 31 * result + comics.hashCode()
        result = 31 * result + series.hashCode()
        result = 31 * result + characters.hashCode()
        return result
    }
}
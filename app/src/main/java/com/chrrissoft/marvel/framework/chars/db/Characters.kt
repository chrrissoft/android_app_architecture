package com.chrrissoft.marvel.framework.chars.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chrrissoft.marvel.framework.chars.db.Characters.Companion.CHARS_TABLE
import com.chrrissoft.marvel.framework.db.ComicPreview
import com.chrrissoft.marvel.framework.db.EventPreview
import com.chrrissoft.marvel.framework.db.SeriesPreview
import com.chrrissoft.marvel.framework.db.StoriesPreview

@Entity(tableName = CHARS_TABLE)
data class Characters(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: ByteArray,
    @ColumnInfo(name = "comics") val comics: ComicPreview,
/*    @ColumnInfo(name = "series") val series: List<SeriesPreview>,
    @ColumnInfo(name = "events") val events: List<EventPreview>,
    @ColumnInfo(name = "stories") val stories: List<StoriesPreview>*/
) {
    companion object {
        internal const val CHARS_TABLE = "chars_table"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Characters

        if (id != other.id) return false
        if (name != other.name) return false
        if (!image.contentEquals(other.image)) return false
        if (comics != other.comics) return false
//        if (series != other.series) return false
//        if (events != other.events) return false
//        if (stories != other.stories) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + image.contentHashCode()
        result = 31 * result + comics.hashCode()
//        result = 31 * result + series.hashCode()
//        result = 31 * result + events.hashCode()
//        result = 31 * result + stories.hashCode()
        return result
    }
}
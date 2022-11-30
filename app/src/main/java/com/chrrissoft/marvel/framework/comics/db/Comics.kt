package com.chrrissoft.marvel.framework.comics.db

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
    @ColumnInfo(name = "image") val image: ByteArray,
    @ColumnInfo(name = "events") val events: List<EventPreview>,
    @ColumnInfo(name = "series") val series: List<SeriesPreview>,
    @ColumnInfo(name = "stories") val stories: List<StoriesPreview>,
    @ColumnInfo(name = "characters") val characters: List<CharacterPreview>,
) {
    companion object {
        internal const val COMICS_TABLE = "comics_table"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Comics

        if (id != other.id) return false
        if (title != other.title) return false
        if (!image.contentEquals(other.image)) return false
        if (events != other.events) return false
        if (series != other.series) return false
        if (stories != other.stories) return false
        if (characters != other.characters) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + image.contentHashCode()
        result = 31 * result + events.hashCode()
        result = 31 * result + series.hashCode()
        result = 31 * result + stories.hashCode()
        result = 31 * result + characters.hashCode()
        return result
    }
}
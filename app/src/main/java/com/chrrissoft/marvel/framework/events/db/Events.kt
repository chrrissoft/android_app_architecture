package com.chrrissoft.marvel.framework.events.db

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
    @ColumnInfo(name = "image") val image: ByteArray,
    @ColumnInfo(name = "series") val series: List<SeriesPreview>,
    @ColumnInfo(name = "comics") val comics: List<ComicPreview>,
    @ColumnInfo(name = "stories") val stories: List<StoriesPreview>,
    @ColumnInfo(name = "characters") val characters: List<CharacterPreview>,
) {
    companion object {
        internal const val EVENTS_TABLE = "events_table"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Events

        if (id != other.id) return false
        if (title != other.title) return false
        if (!image.contentEquals(other.image)) return false
        if (series != other.series) return false
        if (comics != other.comics) return false
        if (stories != other.stories) return false
        if (characters != other.characters) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + image.contentHashCode()
        result = 31 * result + series.hashCode()
        result = 31 * result + comics.hashCode()
        result = 31 * result + stories.hashCode()
        result = 31 * result + characters.hashCode()
        return result
    }
}
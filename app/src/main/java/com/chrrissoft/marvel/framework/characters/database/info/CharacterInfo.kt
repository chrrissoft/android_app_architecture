package com.chrrissoft.marvel.framework.characters.database.info

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.chrrissoft.marvel.data.characters.models.CharacterInfo
import com.chrrissoft.marvel.framework.characters.database.converters.*
import com.chrrissoft.marvel.framework.characters.database.info.CharacterInfo.Companion.TABLE_TABLE


@Entity(tableName = TABLE_TABLE)
@TypeConverters(
    ImageConverter::class,
    ComicsConverter::class,
    SeriesConverter::class,
    StoriesConverter::class,
    EventsConverter::class,
)
data class CharacterInfo(
    @PrimaryKey
    @ColumnInfo(name = "id") override val id: Int,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "description") override val description: String,
    @ColumnInfo(name = "thumbnail") override val thumbnail: Bitmap,
    @ColumnInfo(name = "comics") override val comics: Comics,
    @ColumnInfo(name = "series") override val series: Series,
    @ColumnInfo(name = "stories") override val stories: Stories,
    @ColumnInfo(name = "events") override val events: Events,
) : CharacterInfo {
    companion object {
        const val TABLE_TABLE = "character_info"
    }
}
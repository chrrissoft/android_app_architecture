package com.chrrissoft.marvel.framework.characters.database.preview

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.chrrissoft.marvel.data.characters.models.CharactersPreview
import com.chrrissoft.marvel.framework.characters.database.converters.ImageConverter
import com.chrrissoft.marvel.framework.characters.database.preview.CharacterPreview.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
@TypeConverters(ImageConverter::class)
data class CharacterPreview(
    @PrimaryKey
    @ColumnInfo(name = "id") override val id: Int,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "thumbnail") override val thumbnail: Bitmap,
) : CharactersPreview {
    companion object {
        const val TABLE_NAME = "character_preview"
    }
}
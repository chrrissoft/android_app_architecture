package com.chrrissoft.marvel.framework.characters.database.preview

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterPreviewDao {
    @Query("SELECT * FROM character_preview")
    fun getAll() : Flow<List<CharacterPreview>>

    @Delete
    suspend fun delete(character: CharacterPreview)

    @Insert
    suspend fun insertAll(vararg users: CharacterPreview)
}


package com.chrrissoft.marvel.framework.characters.database.info

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterInfoDao {
    @Query("SELECT * FROM character_info WHERE id = :id")
    fun getById(id: Int) : Flow<CharacterInfo>

    @Delete
    suspend fun delete(character: CharacterInfo)

    @Insert
    suspend fun insertAll(vararg users: CharacterInfo)
}
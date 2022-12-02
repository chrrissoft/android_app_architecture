package com.chrrissoft.marvel.framework.chars.db

import androidx.room.Dao
import androidx.room.Query
import com.chrrissoft.marvel.framework.db.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

/*    @Insert(onConflict = REPLACE)
    suspend fun save(vararg new: CharacterPreview)*/

/*    @Query("SELECT * FROM chars_table")
    fun getChars(): Flow<List<CharacterPreview>>*/

    @Query("SELECT * FROM chars_table WHERE chars_table.id = :id")
    fun get(id: Int) : Flow<Characters>

    @Query("SELECT comics FROM chars_table")
    fun getComics() : Flow<ComicPreview>

/*    @Query("SELECT series FROM chars_table")
    fun getSeries(id: Int) : Flow<List<SeriesPreview>>

    @Query("SELECT stories FROM chars_table")
    fun getStories(id: Int) : Flow<List<StoriesPreview>>

    @Query("SELECT events FROM chars_table")
    fun getEvents(id: Int) : Flow<List<EventPreview>>*/

}
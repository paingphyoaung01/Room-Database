package com.ppa.roomdatabase.Dao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.ppa.roomdatabase.Entity.Word

@Dao
interface WordDao {
    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAlphabetizedWord() : LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word : Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}
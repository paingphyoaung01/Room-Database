package com.ppa.roomdatabase.Repository

import androidx.lifecycle.LiveData
import com.ppa.roomdatabase.Dao.WordDao
import com.ppa.roomdatabase.Entity.Word

// Repository is Local Data and Network Data manages used
class WordRepository(private val wordDao : WordDao) {

    val allWords  = wordDao.getAlphabetizedWord() // Get

    suspend fun insert(word: Word){  // Insert
        wordDao.insert(word)
    }
}
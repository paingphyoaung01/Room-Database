package com.ppa.roomdatabase.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ppa.roomdatabase.Database.WordRoomDatabase
import com.ppa.roomdatabase.Entity.Word
import com.ppa.roomdatabase.Repository.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var  repository : WordRepository

    var  allWords : LiveData<List<Word>>


    init {
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch (Dispatchers.IO){
        repository.insert(word)
    }

}
package com.example.pokescanner.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pokescanner.db.CapturedPkmn
import com.example.pokescanner.db.CapturedPkmnDatabase
import com.example.pokescanner.db.CapturedPkmnRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CapturedPkmnViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<CapturedPkmn>>
    private val repository: CapturedPkmnRepository

    //Class constructor
    init {
        val capturedPkmnDao = CapturedPkmnDatabase.getDatabase(application).capturedPkmnDao()
        repository = CapturedPkmnRepository(capturedPkmnDao)
        readAllData = repository.readAllCapturedEntries
    }

    fun AddCapturedEntry(capturedPkmn: CapturedPkmn) {
        // Launching datebase query off of another thread as it's
        // Good practice to do so, some query could be expensive in performance
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCapturedEntry(capturedPkmn)
        }
    }
}
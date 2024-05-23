package com.example.pokescanner.db

import androidx.lifecycle.LiveData

class CapturedPkmnRepository(private val capturedPkmnDao: CapturedPkmnDao) {
    val readAllCapturedEntries: LiveData<List<CapturedPkmn>> = capturedPkmnDao.readAll()

    suspend fun addCapturedEntry(entry: CapturedPkmn) {
        capturedPkmnDao.insert(entry)
    }
}
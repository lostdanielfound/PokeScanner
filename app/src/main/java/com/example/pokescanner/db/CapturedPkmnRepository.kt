package com.example.pokescanner.db

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class CapturedPkmnRepository(private val capturedPkmnDao: CapturedPkmnDao) {
    val readAllCapturedEntries: LiveData<List<CapturedPkmn>> = capturedPkmnDao.readAll()
    suspend fun addCapturedEntry(entry: CapturedPkmn) {
        capturedPkmnDao.insert(entry)
    }

    fun readCapturedPkmnList(PkmnID: Int): Flow<List<CapturedPkmn>> {
        return capturedPkmnDao.readCapturedPkmnList(PkmnID)
    }
}
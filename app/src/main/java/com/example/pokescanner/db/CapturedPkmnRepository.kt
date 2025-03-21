package com.example.pokescanner.db

import kotlinx.coroutines.flow.Flow

class CapturedPkmnRepository(private val capturedPkmnDao: CapturedPkmnDao) {
    val readAllCapturedEntries: Flow<List<CapturedPkmn>> = capturedPkmnDao.readAll()
    suspend fun addCapturedEntry(entry: CapturedPkmn) {
        capturedPkmnDao.insert(entry)
    }

    fun readCapturedPkmnList(PkmnID: Int): Flow<List<CapturedPkmn>> {
        return capturedPkmnDao.readCapturedPkmnList(PkmnID)
    }
}

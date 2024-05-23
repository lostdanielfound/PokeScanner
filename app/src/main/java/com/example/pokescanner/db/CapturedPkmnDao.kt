package com.example.pokescanner.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CapturedPkmnDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: CapturedPkmn)

    @Query("SELECT * FROM capturedPkmn_table ORDER BY capturedID ASC")
    fun readAll(): LiveData<List<CapturedPkmn>>
}
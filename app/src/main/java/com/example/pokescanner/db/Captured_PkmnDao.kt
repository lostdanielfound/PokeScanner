package com.example.pokescanner.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface Captured_PkmnDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: Captured_Pkmn)
}
package com.example.pokescanner.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface Captured_PkmnDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pkmn: Pokemon)

    @Update
    suspend fun update(updatePkmn: Pokemon)

    @Delete
    suspend fun delete(pkmn: Pokemon)
}
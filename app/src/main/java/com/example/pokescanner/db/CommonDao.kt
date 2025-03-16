package com.example.pokescanner.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CapturedPkmnDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: CapturedPkmn)

    @Query("SELECT * FROM capturedPkmn_table ORDER BY capturedID ASC")
    fun readAll(): Flow<List<CapturedPkmn>>

    @Query("SELECT * FROM capturedPkmn_table WHERE pkmnfk_ID == :pkmnID ORDER BY capture_time")
    fun readCapturedPkmnList(pkmnID: Int): Flow<List<CapturedPkmn>>
}

@Dao
interface PlayerStatsDao {
    @Query("SELECT * FROM playerStats_table WHERE rowID == :rowID")
    fun readStats(rowID: Int): Flow<PlayerStats>
}
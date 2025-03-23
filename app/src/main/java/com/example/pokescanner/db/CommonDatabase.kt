package com.example.pokescanner.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CapturedPkmn::class, PlayerStats::class], version = 1, exportSchema = false)
abstract class CommonDatabase: RoomDatabase() {

    abstract fun capturedPkmnDao(): CapturedPkmnDao
    abstract fun playerStatsDao(): PlayerStatsDao
}
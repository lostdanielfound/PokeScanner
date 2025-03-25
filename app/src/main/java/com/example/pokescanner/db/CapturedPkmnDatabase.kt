package com.example.pokescanner.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CapturedPkmn::class], version = 1, exportSchema = false)
abstract class CapturedPkmnDatabase: RoomDatabase() {

    abstract fun capturedPkmnDao(): CapturedPkmnDao
}
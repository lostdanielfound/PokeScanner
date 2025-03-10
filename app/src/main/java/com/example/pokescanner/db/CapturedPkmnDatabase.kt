package com.example.pokescanner.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CapturedPkmn::class], version = 1, exportSchema = true)
abstract class CapturedPkmnDatabase: RoomDatabase() {
    abstract fun capturedPkmnDao(): CapturedPkmnDao

    /*
    companion object{
        @Volatile //Creating an atomic Instance of the database
        private var INSTANCE: CapturedPkmnDatabase? = null

        //Function to get and start building process of database
        //If instance variable is already set with current state
        //of database we will return that since building a database
        //is quite expensive for performance.
        fun getDatabase(context: Context): CapturedPkmnDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CapturedPkmnDatabase::class.java,
                    "CapturedPkmn_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

     */
}
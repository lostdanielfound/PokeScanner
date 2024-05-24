package com.example.pokescanner.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon_table")
    fun readAllPokemon(): LiveData<List<Pokemon>>
}

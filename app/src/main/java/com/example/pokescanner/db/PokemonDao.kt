package com.example.pokescanner.db

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon_table")
    fun readAllPokemon(): Flow<List<Pokemon>>
}

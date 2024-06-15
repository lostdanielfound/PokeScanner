package com.example.pokescanner.db

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon_table")
    fun readAllPokemon(): Flow<List<Pokemon>>

    @Query("SELECT ID, Name, Species, Type1, Type2, Height, Weight, Description, Thumbnail " +
            "FROM pokemon_table WHERE ID == :pokedexID")
    suspend fun readPokemon(pokedexID: Int): Flow<Pokemon>
}

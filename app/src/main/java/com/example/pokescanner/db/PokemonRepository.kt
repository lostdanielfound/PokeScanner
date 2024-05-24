package com.example.pokescanner.db

import kotlinx.coroutines.flow.Flow

class PokemonRepository(private val pokemonDao: PokemonDao) {
    val readAllPokemon: Flow<List<Pokemon>> = pokemonDao.readAllPokemon()
}
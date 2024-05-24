package com.example.pokescanner.db

import androidx.lifecycle.LiveData

class PokemonRepository(private val pokemonDao: PokemonDao) {
    val readAllPokemon: LiveData<List<Pokemon>> = pokemonDao.readAllPokemon()
}
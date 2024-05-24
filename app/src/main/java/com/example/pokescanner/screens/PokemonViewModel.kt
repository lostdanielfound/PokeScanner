package com.example.pokescanner.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.db.PokemonDatabase
import com.example.pokescanner.db.PokemonRepository

class PokemonViewModel(application: Application): AndroidViewModel(application) {

    private val repository: PokemonRepository
    private val pokemonList: LiveData<List<Pokemon>>

    init {
        val pokemonDao = PokemonDatabase.getDatabase(application).pokemonDao()
        repository = PokemonRepository(pokemonDao)
        pokemonList = repository.readAllPokemon
    }
}
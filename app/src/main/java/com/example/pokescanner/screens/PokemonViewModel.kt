package com.example.pokescanner.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.db.PokemonDatabase
import com.example.pokescanner.db.PokemonRepository
import kotlinx.coroutines.flow.Flow

class PokemonViewModel(pokemonRepository: PokemonRepository): ViewModel() {

    private val _pokemonList = pokemonRepository.readAllPokemon

    fun getJournalList(): Flow<List<Pokemon>> {
        return _pokemonList
    }

}
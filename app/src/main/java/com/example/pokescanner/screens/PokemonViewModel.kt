package com.example.pokescanner.screens

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.db.PokemonDatabase
import com.example.pokescanner.db.PokemonRepository
import kotlinx.coroutines.flow.Flow

class PokemonViewModel(application: Application): AndroidViewModel(application) {

    //Need pokemonDao to get access by pokemonRepo
    private val _pokemonList: Flow<List<Pokemon>>
    private val pokemonRepository: PokemonRepository

    init {
        val pokemonDao = PokemonDatabase.getDatabase(application).pokemonDao()
        pokemonRepository = PokemonRepository(pokemonDao)
        _pokemonList = pokemonRepository.readAllPokemon
    }

    fun getJournalList(): Flow<List<Pokemon>> {
        return _pokemonList
    }

    fun clickedEntry(pkmnID: Int) {

    }

}
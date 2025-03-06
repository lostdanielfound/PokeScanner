package com.example.pokescanner.screens.journalscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.db.PokemonDatabase
import com.example.pokescanner.db.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class JournalViewmodel(application: Application): AndroidViewModel(application) {

    private val _journalState = MutableStateFlow(JournalState(temp = 0))
    val journalState: StateFlow<JournalState> = _journalState.asStateFlow()

    private val pokemonList: Flow<List<Pokemon>> // Flow object that fills list of pokemon objects
    private val pokemonRepository: PokemonRepository // Interactive Repository to access / modify

    init {
        val pokemonDao = PokemonDatabase.getDatabase(application).pokemonDao()
        pokemonRepository = PokemonRepository(pokemonDao)
        pokemonList = pokemonRepository.readAllPokemon
    }

    fun getPokemonList(): Flow<List<Pokemon>> {
        return pokemonList
    }
}
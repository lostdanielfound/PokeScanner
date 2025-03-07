package com.example.pokescanner.screens.journalscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.db.PokemonDatabase
import com.example.pokescanner.db.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class JournalViewmodel @Inject constructor(
    pokemonRepositoryImpl: PokemonRepository,
): ViewModel() {

    private val _journalState = MutableStateFlow(JournalState(temp = 0))
    val journalState: StateFlow<JournalState> = _journalState.asStateFlow()

    private val pokemonList: Flow<List<Pokemon>> =
        pokemonRepositoryImpl.readAllPokemon // Flow object that fills list of pokemon objects

    fun getPokemonList(): Flow<List<Pokemon>> {
        return pokemonList
    }
}
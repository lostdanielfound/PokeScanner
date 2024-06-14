package com.example.pokescanner.screens

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.db.PokemonDatabase
import com.example.pokescanner.db.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(AppUiState(Stats(0,0,0), 1))
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

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

    fun setPokedexIndex(index: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                currentPokedexIndex = index
            )
        }
    }

    fun resetState() {
        _uiState.value = AppUiState(Stats(0,0,0), 1)
    }

}
package com.example.pokescanner.screens

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.pokescanner.db.NullPokemon
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.db.PokemonDatabase
import com.example.pokescanner.db.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {

    /*
        ui state for the application set as a flow object to mutate state
     */
    private val _uiState = MutableStateFlow(
        AppUiState(
            Stats(
                totalImagesTaken = 0,
                totalPkmnCaptured = 0,
                totalPkmnEntriesCompleted = 0,
            ),
            currentPokemonEntryView = NullPokemon.getNullPokemon()
        )
    )
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    private val pokemonList: Flow<List<Pokemon>> // Flow object that fills list of pokemon objects
    private val pokemonRepository: PokemonRepository // Interactive Repository to access / modify

    init {
        val pokemonDao = PokemonDatabase.getDatabase(application).pokemonDao()
        pokemonRepository = PokemonRepository(pokemonDao)
        pokemonList = pokemonRepository.readAllPokemon
    }

    fun getJournalList(): Flow<List<Pokemon>> {
        return pokemonList
    }

    fun UpdatePokemonEntry(index: Int) {
        // run async dao function to collection pokemon object.
        // Prefer observable state rather than suspend functions from the ViewModel
        viewModelScope.launch {
            val pokemonEntry: Pokemon = pokemonRepository.readPokemon(index)
            _uiState.update { currentState ->
                currentState.copy(
                    currentPokemonEntryView = pokemonEntry
                )
            }
        }
    }

    fun resetState() {
        _uiState.value = AppUiState(
            Stats(
            totalImagesTaken = 0,
            totalPkmnCaptured = 0,
            totalPkmnEntriesCompleted = 0
        ),
            currentPokemonEntryView = NullPokemon.getNullPokemon()
        )
    }

}
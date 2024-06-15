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
            currentPokedexIndex = 1
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

    fun setPokedexIndex(index: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                currentPokedexIndex = index
            )
        }
    }

    suspend fun readPokemon(index: Int): Flow<Pokemon> {
        //run async dao function to collection pokemon object.
        return pokemonRepository.readPokemon(index)
    }

    fun resetState() {
        _uiState.value = AppUiState(Stats(0,0,0), 1)
    }

}
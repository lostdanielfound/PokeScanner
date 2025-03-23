package com.example.pokescanner.screens.entryscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokescanner.db.NullPokemon
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.db.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EntryViewmodel @Inject constructor(
    private val pokemonRepositoryImpl: PokemonRepository
): ViewModel() {

    private val _entryState = MutableStateFlow(EntryState(pokemon = NullPokemon.getNullPokemon()))
    val entryState = _entryState.asStateFlow()

    /**
     * Function will be used during init of view model to initalizing the UI state with the loaded
     * pokemon that was selected from the JournalScreen
     *
     * @param pokemonId The ID of the pokemon that was select from the JournalScreen Nav composable
     */
    private fun getPokemon(pokemonId: Int): Flow<Pokemon> {
        return pokemonRepositoryImpl.readPokemon(pokemonId)
    }

    fun updatePokemonEntry(pokemonId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getPokemon(pokemonId).collect { pkmn ->
                _entryState.value = EntryState(pokemon = pkmn)
            }
        }
    }

}
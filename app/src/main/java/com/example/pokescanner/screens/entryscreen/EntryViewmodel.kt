package com.example.pokescanner.screens.entryscreen

import androidx.lifecycle.ViewModel
import com.example.pokescanner.db.NullPokemon
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.db.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EntryViewmodel @Inject constructor(
    pokemonRepositoryImpl: PokemonRepository
): ViewModel() {

    private val _entryState = MutableStateFlow(EntryState(pokemon = NullPokemon.getNullPokemon()))
    val entryState = _entryState.asStateFlow()

    /**
     * Function will be used during init of view model to initalizing the UI state with the loaded
     * pokemon that was selected from the JournalScreen
     *
     * @param pokemonId The ID of the pokemon that was select from the JournalScreen Nav composable
     */
    private fun getPokemonId(pokemonId: Int): Pokemon {

        //TODO: Design the process of querying the database
        return NullPokemon.getNullPokemon()
    }
}
package com.example.pokescanner.screens.journalscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokescanner.composables.EntryCardRow
import com.example.pokescanner.db.Pokemon

@Composable
fun JournalScreen(
    onEntryClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    journalViewmodel: JournalViewmodel = viewModel()
) {
    //Upon Viewmodel init, you should be able to get the pokemon list from the db.
    val journalState = journalViewmodel.journalState.collectAsState()
    val pokemonList = journalViewmodel.getPokemonList().collectAsState(initial = emptyList()).value

    LazyColumn(modifier = modifier) {
        items(pokemonList) { entry ->
            EntryCardRow(pkmn = entry, onClick = onEntryClick)
        }
    }
}
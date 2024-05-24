package com.example.pokescanner.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokescanner.composables.EntryCardRow
import com.example.pokescanner.db.Pokemon

@Composable
fun EntryList(entryList: List<Pokemon>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(entryList) { entry ->
            EntryCardRow(pkmn = entry)
        }
    }
}

@Composable
fun JournalScreen(
    pokemonList: List<Pokemon>,
    modifier: Modifier = Modifier
) {
    EntryList(entryList = pokemonList)
}
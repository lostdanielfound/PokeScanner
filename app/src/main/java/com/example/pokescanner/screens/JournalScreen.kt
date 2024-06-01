package com.example.pokescanner.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokescanner.composables.EntryCardRow
import com.example.pokescanner.db.Pokemon

@Composable
fun JournalScreen(
    pokemonList: List<Pokemon>,
    entryOnClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(pokemonList) { entry ->
            EntryCardRow(pkmn = entry, entryOnClick)
        }
    }
}
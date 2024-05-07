package com.example.pokescanner.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokescanner.composables.EntryCardRow
import com.example.pokescanner.model.LoadPkmnData
import com.example.pokescanner.model.Pkmn

@Composable
fun EntryList(entryList: List<Pkmn>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(entryList) { entry ->
            EntryCardRow(pkmn = entry)
        }
    }
}

@Composable
fun JournalScreen(modifier: Modifier = Modifier) {
    EntryList(entryList = LoadPkmnData().LoadData())
}
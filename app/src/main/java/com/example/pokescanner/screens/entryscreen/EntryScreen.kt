package com.example.pokescanner.screens.entryscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokescanner.composables.DetailedEntryCard
import com.example.pokescanner.db.NullPokemon
import com.example.pokescanner.db.Pokemon
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryScreen(
    pokemonId: Int,
    modifier: Modifier = Modifier,
    entryViewmodel: EntryViewmodel = hiltViewModel()
) {
    /*
    https://medium.com/@nosilverbullet/jetpack-compose-suspend-functions-insit de-composables-c0ac4568eed4
     */
    val entryState = entryViewmodel.entryState.collectAsState()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = null)
                        Text(text = entryState.value.pokemon.name)
                    }
                },
            ) 
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(innerPadding)
        ) {
            LaunchedEffect({}) {
                scope.launch {
                    entryViewmodel.updatePokemonEntry(pokemonId)
                }
            }
            DetailedEntryCard(entryState.value.pokemon)
            Row {
                //Develop camera mechanism to put pictures here.
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EntryScreenPreview() {
    EntryScreen(0)
}
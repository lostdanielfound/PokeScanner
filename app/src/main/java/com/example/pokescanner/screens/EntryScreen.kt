package com.example.pokescanner.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.pokescanner.db.NullPokemon
import com.example.pokescanner.db.Pokemon
import kotlinx.coroutines.flow.Flow


@Composable
fun EntryScreen(
    loadingPokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    /*
    https://medium.com/@nosilverbullet/jetpack-compose-suspend-functions-inside-composables-c0ac4568eed4
     */
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Text("Passed In pokedex ID: ${loadingPokemon.ID} and name is ${loadingPokemon.name}")
    }
}

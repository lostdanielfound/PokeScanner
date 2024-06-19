package com.example.pokescanner.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.pokescanner.db.NULL_VALUE
import com.example.pokescanner.db.Pokemon


@Composable
fun EntryScreen(
    pokedexID: Int,
    getPokemon: (Int) -> Pokemon,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val pokemon by remember { mutableStateOf<Pokemon>(Pokemon(
        NULL_VALUE,
        "---",
        "---",
        "---",
        null,
        0.0,
        0.0,
        "---",
        null
    )) }
    /*
    https://medium.com/@nosilverbullet/jetpack-compose-suspend-functions-inside-composables-c0ac4568eed4
     */
    LaunchedEffect(scope) {
        pokemon.copy(
           /* Tf do i put here*/
        )
    }
    
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Text("Passed In pokedex ID: $pokedexID")
    }
}

package com.example.pokescanner.screens

import com.example.pokescanner.db.Pokemon

data class AppUiState(
    val stats: Stats,
    val currentPokemonEntryView: Pokemon
)

package com.example.pokescanner.datasource

import androidx.annotation.DrawableRes

data class Pkmn(
    val id: Int,
    val name: String,
    val types: List<String>,
    val pokeDexEntry: String,
    @DrawableRes val thumbnail: Int?
)
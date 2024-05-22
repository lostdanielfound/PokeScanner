package com.example.pokescanner.model

import androidx.annotation.DrawableRes

data class Pkmn(
    val id: Int,
    val name: String,
    val species: String,
    val types: List<String>,
    val height: Double, // Metric Meters
    val weight: Double, // Metric Kilograms
    val pokeDexEntry: String,
    @DrawableRes val thumbnail: Int?
)
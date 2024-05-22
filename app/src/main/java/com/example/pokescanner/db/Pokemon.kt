package com.example.pokescanner.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pokemon(
    @PrimaryKey(autoGenerate = true) val pkmnID: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "species") val species: String,
    @ColumnInfo(name = "types") val types: List<String>,
    @ColumnInfo(name = "height") val height: Double, // Metric Meters
    @ColumnInfo(name = "weight") val weight: Double, // Metric Kilograms
    @ColumnInfo(name = "description") val description: String
)

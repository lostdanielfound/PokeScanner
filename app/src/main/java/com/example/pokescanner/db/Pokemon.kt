package com.example.pokescanner.db

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Blob

@Entity(tableName = "pokemon_table")
data class Pokemon(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "ID") val ID: Int,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "Species") val species: String,
    @ColumnInfo(name = "Type1") val type1: String,
    @ColumnInfo(name = "Type2") val type2: String?,
    @ColumnInfo(name = "Height") val height: Float, // Metric Meters
    @ColumnInfo(name = "Weight") val weight: Float, // Metric Kilograms
    @ColumnInfo(name = "Description") val description: String,
    @ColumnInfo(name = "Thumbnail") val thumbnail: Blob //Blob
)
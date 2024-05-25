package com.example.pokescanner.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Blob

@Entity(tableName = "pokemon_table")
data class Pokemon(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "ID") val ID: Int,
    @ColumnInfo(name = "Name", typeAffinity = ColumnInfo.TEXT) val name: String,
    @ColumnInfo(name = "Species", typeAffinity = ColumnInfo.TEXT) val species: String,
    @ColumnInfo(name = "Type1", typeAffinity = ColumnInfo.TEXT) val type1: String,
    @ColumnInfo(name = "Type2", typeAffinity = ColumnInfo.TEXT) val type2: String?,
    @ColumnInfo(name = "Height", typeAffinity = ColumnInfo.REAL) val height: Double, // Metric Meters
    @ColumnInfo(name = "Weight", typeAffinity = ColumnInfo.REAL) val weight: Double, // Metric Kilograms
    @ColumnInfo(name = "Description", typeAffinity = ColumnInfo.TEXT) val description: String,
    @ColumnInfo(name = "Thumbnail", typeAffinity = ColumnInfo.BLOB) val thumbnail: ByteArray //Blob
)
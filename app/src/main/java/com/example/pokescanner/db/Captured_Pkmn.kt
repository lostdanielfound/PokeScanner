package com.example.pokescanner.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import kotlin.reflect.KClass

@Entity(
    foreignKeys = [ForeignKey(
        entity = Pokemon::class,
        parentColumns = arrayOf("pkmnID"),
        childColumns = arrayOf("pkmn"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Captured_Pkmn(
    @PrimaryKey(autoGenerate = true) val captured_ID: Int,
    @ColumnInfo(name = "pkmn") val pkmn: String,
    @ColumnInfo(name = "capture_time") val captured_time: LocalDateTime,
    @ColumnInfo(name = "image_base64") val image_base64: String
)

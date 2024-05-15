package com.example.pokescanner.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import kotlin.reflect.KClass

@Entity
data class Captured_Pkmn(
    @PrimaryKey(autoGenerate = true) val captured_ID: Int,
    @ColumnInfo(name = "pkmnfk_ID") val pkmn: Int,
    @ColumnInfo(name = "capture_time") val captured_time: LocalDateTime,
    @ColumnInfo(name = "image_base64") val image_base64: String
)

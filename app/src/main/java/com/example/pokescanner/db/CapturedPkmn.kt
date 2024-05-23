package com.example.pokescanner.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity("capturedPkmn_table")
data class CapturedPkmn(
    @PrimaryKey(autoGenerate = true) val capturedID: Int,
    @ColumnInfo(name = "pkmnfk_ID") val pkmn: Int,
    @ColumnInfo(name = "capture_time") val capturedTime: LocalDateTime,
    @ColumnInfo(name = "image_base64") val imageBase64: String
)

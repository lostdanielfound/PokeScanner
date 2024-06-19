package com.example.pokescanner.db

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokescanner.R
import java.time.LocalDateTime

@Entity("capturedPkmn_table")
data class CapturedPkmn(
    @PrimaryKey(autoGenerate = true) val capturedID: Int,
    @ColumnInfo(name = "pkmnfk_ID") val pkmn: Int,

    //LocalDateTime in kotlin
    //String in SQLlite
    @ColumnInfo(name = "capture_time") val capturedTime: String, //Need to be changed into LONG for epoch
    @ColumnInfo(name = "image_base64") val imageBase64: String
)
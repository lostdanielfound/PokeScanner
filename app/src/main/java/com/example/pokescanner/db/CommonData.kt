package com.example.pokescanner.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("capturedPkmn_table")
data class CapturedPkmn(
    @PrimaryKey(autoGenerate = true) val capturedID: Int,
    @ColumnInfo(name = "pkmnfk_ID") val pkmn: Int,

    //LocalDateTime in kotlin
    //String in SQLlite
    @ColumnInfo(name = "capture_time") val capturedTime: String, //Need to be changed into LONG for epoch
    @ColumnInfo(name = "image_base64") val imageBase64: String
)

@Entity(tableName = "playerStats_table")
data class PlayerStats (
    @PrimaryKey(autoGenerate = true) val rowID: Int,
    @ColumnInfo val totalImagesTaken: Int = 0,
    @ColumnInfo val totalPkmnCaptured: Int = 0,
    @ColumnInfo val totalPkmnEntriesCompleted: Int = 0,
    @ColumnInfo val medal1Completed: Boolean = false,
    @ColumnInfo val medal2Completed: Boolean = false,
    @ColumnInfo val medal3Completed: Boolean = false,
    @ColumnInfo val medal4Completed: Boolean = false,
)

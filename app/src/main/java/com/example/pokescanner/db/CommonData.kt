package com.example.pokescanner.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokescanner.screens.statsscreen.Stats

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
    @ColumnInfo("total_images_taken") val totalImagesTaken: Int = 0,
    @ColumnInfo("total_pkmn_captured") val totalPkmnCaptured: Int = 0,
    @ColumnInfo("total_pkmn_entries_completed") val totalPkmnEntriesCompleted: Int = 0,
    @ColumnInfo("medal1_completed") val medal1Completed: Boolean = false,
    @ColumnInfo("medal2_completed") val medal2Completed: Boolean = false,
    @ColumnInfo("medal3_completed") val medal3Completed: Boolean = false,
    @ColumnInfo("medal4_completed") val medal4Completed: Boolean = false,
) {
    fun toStats(): Stats {
        return Stats(
            totalImagesTaken = totalImagesTaken,
            totalPkmnCaptured = totalPkmnCaptured,
            totalPkmnEntriesCompleted = totalPkmnEntriesCompleted,
            medal1Completed = medal1Completed,
            medal2Completed = medal2Completed,
            medal3Completed = medal3Completed,
            medal4Completed = medal4Completed
        )
    }
}

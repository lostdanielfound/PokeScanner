package com.example.pokescanner.db

import kotlinx.serialization.Serializable

@Serializable
data class PlayerStats (
    val totalImagesTaken: Int = 0,
    val totalPkmnCaptured: Int = 0,
    val totalPkmnEntriesCompleted: Int = 0,
    val medal1Completed: Boolean = false,
    val medal2Completed: Boolean = false,
    val medal3Completed: Boolean = false,
    val medal4Completed: Boolean = false,
)
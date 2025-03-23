package com.example.pokescanner.db

import kotlinx.coroutines.flow.Flow

class PlayerStatsRepository(private val playerStatsDao: PlayerStatsDao) {
    val readPlayerStats: Flow<PlayerStats> = playerStatsDao.readStats()

    fun updateStats(stats: PlayerStats) {
        playerStatsDao.updateStats(stats)
    }
}

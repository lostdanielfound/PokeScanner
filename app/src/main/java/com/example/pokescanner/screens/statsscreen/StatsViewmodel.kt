package com.example.pokescanner.screens.statsscreen

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

//@HiltViewModel
class StatsViewmodel: ViewModel() {
    private val _statsState = MutableStateFlow(Stats(
        totalImagesTaken = 0,
        totalPkmnCaptured = 0,
        totalPkmnEntriesCompleted = 0
    ))
    val statsState: StateFlow<Stats> = _statsState.asStateFlow()

    /**
     * Resets the stats and makes a query to obtain stats
     */
    private fun resetState() {

    }
}
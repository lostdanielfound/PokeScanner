package com.example.pokescanner.screens.statsscreen

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokescanner.db.PlayerStats
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatsViewmodel @Inject constructor (
    private val playerStatsDatastoreImpl: DataStore<PlayerStats>
): ViewModel() {
    private var _statsState = MutableStateFlow<Stats?>(null)
    val statsState: StateFlow<Stats?> = _statsState.asStateFlow()

    init {
        Log.d("StatsViewmodel", "StatsViewmodel init")
        viewModelScope.launch(Dispatchers.IO) {
            playerStatsDatastoreImpl.data.collect { playerStats ->
                _statsState.value = Stats(playerStats)
            }
        }
    }
}
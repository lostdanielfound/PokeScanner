package com.example.pokescanner.screens

import androidx.lifecycle.ViewModel
import com.example.pokescanner.composables.Stats
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState(Stats(0,0,0)))
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()


    fun resetState() {
        _uiState.value = AppUiState(Stats(0,0,0))
    }

}
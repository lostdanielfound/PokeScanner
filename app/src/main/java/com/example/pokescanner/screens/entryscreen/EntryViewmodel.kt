package com.example.pokescanner.screens.entryscreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EntryViewmodel(): ViewModel() {
    private val _entryState = MutableStateFlow(EntryState(temp = 0))
    val entryState = _entryState.asStateFlow()

    fun
}
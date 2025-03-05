package com.example.pokescanner.screens.entryscreen

import androidx.lifecycle.ViewModel

class EntryViewmodel(): ViewModel() {
    private var _entryState = MutableStateFlow(EntryState())
    private val entryState = _entryState.asStateFlow()


}
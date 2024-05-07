package com.example.pokescanner.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    //Column(
    ////Camera view here

    //)

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text("HomeScreen")
    }
}

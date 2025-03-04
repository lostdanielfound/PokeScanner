package com.example.pokescanner.screens.entryscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokescanner.composables.DetailedEntryCard
import com.example.pokescanner.db.NullPokemon
import com.example.pokescanner.db.Pokemon


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryScreen(
    loadingPokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    /*
    https://medium.com/@nosilverbullet/jetpack-compose-suspend-functions-insit de-composables-c0ac4568eed4
     */
    //Bruh, this stuff should be in it's own composable
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = null)
                        Text(text = loadingPokemon.name)
                    }
                },
            ) 
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(innerPadding)
        ) {
            DetailedEntryCard(loadingPokemon)
            Row {
                //Develop camera mechanism to put pictures here.
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EntryScreenPreview() {
    val demoPokemon: Pokemon = NullPokemon.getNullPokemon()
    EntryScreen(demoPokemon)
}
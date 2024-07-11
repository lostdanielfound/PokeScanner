package com.example.pokescanner.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokescanner.R
import com.example.pokescanner.composables.DetailedEntryCard
import com.example.pokescanner.db.NullPokemon
import com.example.pokescanner.db.Pokemon
import com.example.pokescanner.utils.BitmapConverter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryScreen(
    loadingPokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    /*
    https://medium.com/@nosilverbullet/jetpack-compose-suspend-functions-inside-composables-c0ac4568eed4
     */
    //Bruh, this stuff should be in it's own composable
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = null)
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
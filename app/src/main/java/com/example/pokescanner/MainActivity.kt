package com.example.pokescanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokescanner.screens.StatsScreen
import com.example.pokescanner.ui.theme.PokeScannerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeScannerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val num_DEBUG1 = (0..50).random()
                    val num_DEBUG2 = (0..50).random()
                    val num_DEBUG3 = (0..50).random()

                    val stats = Stats(num_DEBUG1, num_DEBUG2, num_DEBUG3)
                    StatsScreen(stats = stats)
                }
            }
        }
    }
}
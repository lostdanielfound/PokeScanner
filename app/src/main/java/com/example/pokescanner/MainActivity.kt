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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokescanner.screens.HomeScreen
import com.example.pokescanner.screens.JournalScreen
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
                    /**
                     * Data sourcing before application starts up
                     */
                    val currentStats = Stats(10, 5, 2)


                    /**
                     * Navigation controls of the application
                     */
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { HomeScreen( { navController.navigate("journal") } ) }
                        composable("stats") { StatsScreen(currentStats) }
                        composable("journal") { JournalScreen() }
                    }
                }
            }
        }
    }
}
package com.example.pokescanner

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokescanner.screens.AppViewModel
import com.example.pokescanner.screens.EntryScreen
import com.example.pokescanner.screens.HomeScreen
import com.example.pokescanner.screens.JournalScreen
import com.example.pokescanner.screens.StatsScreen


sealed class NavigationScreen(val route: String, val title: String){
    data object Journal : NavigationScreen("Journal", "Pokedex")
    data object Home : NavigationScreen("Home", "Home")
    data object Stats : NavigationScreen("Stats", "Capture Stats")
    data object Entry : NavigationScreen("Entry", title = "Pkmn")
}


@Composable
fun PokeScannerApp(
    viewModel: AppViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()
    val journalState by viewModel.getJournalList().collectAsState(initial = emptyList())

    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = NavigationScreen.Home.route,
            modifier = Modifier
                .padding(it)
        ) {
            composable(NavigationScreen.Journal.route) {
                JournalScreen(
                    pokemonList = journalState,
                    entryOnClick = {
                        pokedexID: Int ->
                        viewModel.UpdatePokemonEntry(pokedexID)
                        navController.navigate(NavigationScreen.Entry.route)
                    }
                )
            }
            composable(NavigationScreen.Home.route) {
                HomeScreen(modifier = Modifier.fillMaxSize())
            }
            composable(NavigationScreen.Stats.route) {
                StatsScreen(uiState.stats)
            }
            composable(NavigationScreen.Entry.route) {
                EntryScreen(uiState.currentPokemonEntryView) /* Erm do something here so that it loads before loading pokemon entry */
            }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    val navigationFittedIcons = listOf(Icons.Filled.List, Icons.Filled.Home, Icons.Filled.Info)
    val navigationOutlinedIcons = listOf(Icons.Outlined.List, Icons.Outlined.Home, Icons.Outlined.Info)

    val screens = listOf(
        NavigationScreen.Journal,
        NavigationScreen.Home,
        NavigationScreen.Stats,
    )

    var selectedOption by remember { mutableIntStateOf(1) }


    NavigationBar {
        screens.forEachIndexed{ index, option ->
            NavigationBarItem(
                selected = (selectedOption == index),
                onClick = {
                    selectedOption = index
                    navController.navigate(option.route) },
                label = { Text(option.title) },
                icon = {
                    if(index == selectedOption) {
                        Icon(
                            imageVector = navigationFittedIcons[index],
                            contentDescription = "Navigating to $option"
                        )
                    }
                    else {
                        Icon(
                            imageVector = navigationOutlinedIcons[index],
                            contentDescription = "Navigating to $option"
                        )
                    }
                }
            )
        }
    }
}

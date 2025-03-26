package com.example.pokescanner

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokescanner.screens.entryscreen.EntryScreen
import com.example.pokescanner.screens.homescreen.HomeScreen
import com.example.pokescanner.screens.journalscreen.JournalScreen
import com.example.pokescanner.screens.statsscreen.StatsScreen


sealed class NavigationScreen(val route: String, val title: String){
    data object Journal : NavigationScreen("Journal", "Pokedex")
    data object Home : NavigationScreen("Home", "Home")
    data object Stats : NavigationScreen("Stats", "Capture Stats")
    data object Entry : NavigationScreen("Entry/{pokemonId}", title = "Pkmn")
}


@Composable
fun PokeScannerNavigation(
    navController: NavHostController = rememberNavController()
) {
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
                    onEntryClick = { pokemonId ->
                        navController.navigate(
                            NavigationScreen.Entry.route
                            .replace("{pokemonId}", pokemonId.toString())
                        )
                    }
                )
            }
            composable(NavigationScreen.Home.route) {
                HomeScreen(
                    onPhotoTaken = {} //TODO: Will most likely need to dedicate functality to viewmodel
                )
            }
            composable(NavigationScreen.Stats.route) {
                StatsScreen()
            }
            composable(
                route = NavigationScreen.Entry.route,
                arguments = listOf(navArgument("pokemonId") { type = NavType.IntType })
            ) {
                val pokemonId = it.arguments?.getInt("pokemonId") ?: 0 //null check
                EntryScreen(pokemonId, onNavigateBack = { navController.popBackStack() })
            }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    val navigationFittedIcons = listOf(Icons.AutoMirrored.Filled.List, Icons.Filled.Home, Icons.Filled.Info)
    val navigationOutlinedIcons = listOf(Icons.AutoMirrored.Outlined.List, Icons.Outlined.Home, Icons.Outlined.Info)

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

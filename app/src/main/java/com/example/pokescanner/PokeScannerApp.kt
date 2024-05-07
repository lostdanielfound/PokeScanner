package com.example.pokescanner

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.pokescanner.screens.HomeScreen

enum class NavigationOptions{
    Journal,
    Home,
    Stats
}

@Composable
fun PokeScannerApp(
    viewModel: AppViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = NavigationOptions.Home.name
    ) {
        composable(NavigationOptions.Home.name) {
            HomeScreen(modifier = Modifier.fillMaxSize())
            ButtomNavBar(navController = navController)
        }
    }


}

@Composable
fun ButtomNavBar(navController: NavHostController) {
    val navigationOptions = listOf("Journal", "Home", "Stats")
    val navigationFittedIcons = listOf(Icons.Filled.List, Icons.Filled.Home, Icons.Filled.Info)
    val navigationOutlinedIcons = listOf(Icons.Outlined.List, Icons.Outlined.Home, Icons.Outlined.Info)

    var selectedOption by remember { mutableIntStateOf(0) }

    NavigationBar {
        navigationOptions.forEachIndexed{ index, option ->
            NavigationBarItem(
                selected = (selectedOption == index),
                onClick = {
                    selectedOption = index
                    navController.navigate(option) },
                label = { Text(option) },
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

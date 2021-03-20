package com.example.androiddevchallenge.ui.components

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androiddevchallenge.HOME
import com.example.androiddevchallenge.SEARCH
import com.example.androiddevchallenge.SETTINGS
import com.example.androiddevchallenge.ui.components.screens.HomeScreen
import com.example.androiddevchallenge.ui.components.screens.SearchScreen
import com.example.androiddevchallenge.ui.components.screens.SettingsScreen

@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HOME) {
        composable(HOME) {
            HomeScreen()
        }

        composable(SEARCH) {
            SearchScreen()
        }

        composable(SETTINGS) {
            SettingsScreen()
        }
    }
}
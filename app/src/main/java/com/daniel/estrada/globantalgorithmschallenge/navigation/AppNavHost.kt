package com.daniel.estrada.globantalgorithmschallenge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.daniel.estrada.globantalgorithmschallenge.challenges.challenge_1.Challenge1Screen
import com.daniel.estrada.globantalgorithmschallenge.home.HomeScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.HOME.route,
        modifier = modifier
    ) {
        composable(Destinations.HOME.route) { HomeScreen(navigateTo = { navController.navigate(it) })}

        composable(Destinations.CHALLENGE_1.route) { Challenge1Screen() }
    }
}
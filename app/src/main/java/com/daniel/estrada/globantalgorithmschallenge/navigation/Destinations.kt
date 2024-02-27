package com.daniel.estrada.globantalgorithmschallenge.navigation

import androidx.annotation.StringRes
import com.daniel.estrada.globantalgorithmschallenge.R
import com.daniel.estrada.globantalgorithmschallenge.challenges.challenge_1.CHALLENGE_1_ROUTE
import com.daniel.estrada.globantalgorithmschallenge.home.HOME_SCREEN_ROUTE

enum class Destinations(
    val route: String,
    @StringRes val title: Int,
) {
    HOME(
        route = HOME_SCREEN_ROUTE,
        title = R.string.app_name,
    ),
    CHALLENGE_1(
        route = CHALLENGE_1_ROUTE,
        title = R.string.challenge_1_title,
    )
}
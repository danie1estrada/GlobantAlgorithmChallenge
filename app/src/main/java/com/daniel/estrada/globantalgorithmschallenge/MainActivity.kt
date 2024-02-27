package com.daniel.estrada.globantalgorithmschallenge

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.daniel.estrada.globantalgorithmschallenge.home.HOME_SCREEN_ROUTE
import com.daniel.estrada.globantalgorithmschallenge.home.HomeScreen
import com.daniel.estrada.globantalgorithmschallenge.navigation.AppNavHost
import com.daniel.estrada.globantalgorithmschallenge.navigation.Destinations
import com.daniel.estrada.globantalgorithmschallenge.ui.theme.GlobantAlgorithmsChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlobantAlgorithmsChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(navController = rememberNavController())
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = { AppBar(navController = navController) }
    ) { paddingValues ->
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(navController: NavHostController) {
    val navStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackEntry?.destination

    val title = currentDestination?.route?.let {
        Destinations.entries.firstOrNull { entry -> entry.route == it }?.title
    }

    TopAppBar(
        title = { Text(text = stringResource(id = title ?: R.string.app_name)) },
        navigationIcon = {
            AnimatedVisibility(visible = currentDestination?.route?.equals(HOME_SCREEN_ROUTE)?.not() == true) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}
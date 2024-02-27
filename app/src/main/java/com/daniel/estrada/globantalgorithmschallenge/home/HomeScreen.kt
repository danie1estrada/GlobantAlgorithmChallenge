package com.daniel.estrada.globantalgorithmschallenge.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.daniel.estrada.globantalgorithmschallenge.navigation.Destinations

const val HOME_SCREEN_ROUTE = "home"

@Composable
fun HomeScreen(
    navigateTo: (String) -> Unit
) {
    LazyColumn {
        itemsIndexed(items = Destinations.entries) { index, destination ->
            if (index > 0) {
                ListItem(
                    headlineContent = { Text(text = "Challenge #$index") },
                    supportingContent = { Text(stringResource(id = destination.title)) },
                    trailingContent = {
                        Icon(
                            Icons.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    modifier = Modifier.clickable { navigateTo(destination.route) }
                )
                Divider()
            }
        }
    }
}
package com.nvegas.common.navigation.components

import androidx.navigation.NavOptionsBuilder
import com.nvegas.common.navigation.destinations.Destination
import kotlinx.coroutines.flow.Flow

interface Navigator {
    val startDestination: Destination
    val navigationActions: Flow<NavigationAction>

    suspend fun navigate(
        destination: Destination,
        navOptions: NavOptionsBuilder.() -> Unit = {}
    )

    suspend fun navigateUp()

    suspend fun updateStartDestination(newDestination: Destination)
}


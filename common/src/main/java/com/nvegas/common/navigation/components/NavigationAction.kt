package com.nvegas.common.navigation.components

import androidx.navigation.NavOptionsBuilder
import com.nvegas.common.navigation.destinations.Destination

sealed interface NavigationAction {

    data class Navigate(
        val destination: Destination,
        val navOptions: NavOptionsBuilder.() -> Unit = {}
    ): NavigationAction

    data object NavigateUp: NavigationAction
    data class UpdateStartDestination(val destination: Destination): NavigationAction

}
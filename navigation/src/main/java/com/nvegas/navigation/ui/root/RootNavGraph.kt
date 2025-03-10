package com.nvegas.navigation.ui.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.nvegas.core.navigation.components.NavigationAction
import com.nvegas.core.navigation.destinations.Destination
import com.nvegas.navigation.components.ObserveAsEvents
import com.nvegas.presentation.homeGraph
import com.nvegas.presentation.signInGraph
import com.nvegas.presentation.signUpGraph
import com.nvegas.presentation.splashGraph
import kotlinx.coroutines.flow.Flow

@Composable
fun RootNavGraph(navController: NavHostController, startDestination: Destination, flow: Flow<NavigationAction>) {
    ObserveAsEvents(flow = flow) { action ->
        when (action) {
            is NavigationAction.Navigate -> navController.navigate(
                action.destination
            ) {
                action.navOptions(this)
            }

            NavigationAction.NavigateUp -> navController.navigateUp()

            is NavigationAction.UpdateStartDestination -> navController.graph.setStartDestination(
                action.destination
            )
        }
    }
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        splashGraph()
        homeGraph()
        signInGraph()
        signUpGraph()
    }
}
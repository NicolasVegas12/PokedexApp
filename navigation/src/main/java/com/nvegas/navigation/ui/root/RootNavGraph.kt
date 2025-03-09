package com.nvegas.navigation.ui.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.nvegas.common.navigation.components.NavigationAction
import com.nvegas.navigation.components.ObserveAsEvents
import com.nvegas.presentation.homeGraph
import com.nvegas.presentation.signInGraph
import com.nvegas.presentation.splashGraph

@Composable
fun RootNavGraph(navController: NavHostController, viewModel: RootViewModel) {
    ObserveAsEvents(flow = viewModel.navigationActions) { action ->
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
        startDestination = viewModel.startDestination,
    ) {
        splashGraph()
        homeGraph()
        signInGraph()
    }
}
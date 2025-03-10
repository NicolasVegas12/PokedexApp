package com.nvegas.presentation


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nvegas.core.navigation.destinations.HomeDestination
import com.nvegas.core.navigation.destinations.RootDestination

fun NavGraphBuilder.homeGraph() {

    navigation<RootDestination.HomeGraph>(
        startDestination = HomeDestination.HomePrincipalRoute
    ) {
        composable<HomeDestination.HomePrincipalRoute> {

        }

        composable<HomeDestination.HomePokemonTeamRoute> {
        }

        composable<HomeDestination.HomeProfileRoute> {


        }


    }
}
package com.nvegas.presentation


import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.nvegas.core.navigation.destinations.HomeDestination
import com.nvegas.core.navigation.destinations.RootDestination
import com.nvegas.presentation.explore.HomeExploreScreen
import com.nvegas.presentation.explore.HomeExploreViewModel
import com.nvegas.presentation.profile.HomeProfileScreen
import com.nvegas.presentation.team.HomeTeamScreen

fun NavGraphBuilder.homeGraph() {

    navigation<RootDestination.HomeGraph>(
        startDestination = HomeDestination.HomePrincipalRoute
    ) {
        composable<HomeDestination.HomePrincipalRoute> {
            val viewModel = hiltViewModel<HomeExploreViewModel>()
            val pokedexMedia = viewModel.pokedex?.collectAsLazyPagingItems()
            val searchQuery by viewModel.searchQuery
            HomeExploreScreen(pokedexMedia, searchQuery, viewModel::setSearchQuery)
        }

        composable<HomeDestination.HomePokemonTeamRoute> {

            HomeTeamScreen()

        }

        composable<HomeDestination.HomeProfileRoute> {

            HomeProfileScreen()
        }


    }
}
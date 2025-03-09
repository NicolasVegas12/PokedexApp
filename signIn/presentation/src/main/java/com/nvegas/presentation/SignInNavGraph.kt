package com.nvegas.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nvegas.common.navigation.destinations.RootDestination
import com.nvegas.common.navigation.destinations.SignInDestination

fun NavGraphBuilder.signInGraph() {
    navigation<RootDestination.SignInGraph>(
        startDestination = SignInDestination.SignInRoute
    ) {
        composable<SignInDestination.SignInRoute> {

        }

    }
}
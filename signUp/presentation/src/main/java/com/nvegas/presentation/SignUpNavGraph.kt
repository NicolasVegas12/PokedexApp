package com.nvegas.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.nvegas.common.navigation.destinations.RootDestination
import com.nvegas.common.navigation.destinations.SignUpDestination

fun NavGraphBuilder.signUpGraph() {
    navigation<RootDestination.SignUpGraph>(
        startDestination = SignUpDestination.SignUpRoute
    ){
        composable<SignUpDestination.SignUpRoute> {

        }

    }
}
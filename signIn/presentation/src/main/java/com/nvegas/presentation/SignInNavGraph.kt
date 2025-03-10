package com.nvegas.presentation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
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
            val viewModel = hiltViewModel<SignInViewModel>()
            val request by viewModel.currentRequest
            SignInScreen(
                request = request,
                setRequest = viewModel::setRequest,
                signIn = viewModel::signIn,
                navigateToSignUp = viewModel::navigateToSignUp
            )
        }

    }
}
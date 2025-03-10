package com.nvegas.presentation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.nvegas.core.navigation.destinations.RootDestination
import com.nvegas.core.navigation.destinations.SignUpDestination

fun NavGraphBuilder.signUpGraph() {
    navigation<RootDestination.SignUpGraph>(
        startDestination = SignUpDestination.SignUpRoute
    ) {
        composable<SignUpDestination.SignUpRoute> {
            val viewModel = hiltViewModel<SignUpViewModel>()


            val request by viewModel.currentRequest
            val signUpState by viewModel.state
            SignUpScreen(
                request = request,
                signUpState = signUpState,
                setRequest = viewModel::setRequest,
                signUp = viewModel::signUp,
                goBack = viewModel::goBack,
                resetState = viewModel::resetState
            )
        }

    }
}
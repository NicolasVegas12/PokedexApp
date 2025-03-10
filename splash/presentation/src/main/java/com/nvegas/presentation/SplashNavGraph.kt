package com.nvegas.presentation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nvegas.core.navigation.destinations.RootDestination
import com.nvegas.core.navigation.destinations.SplashDestination

fun NavGraphBuilder.splashGraph() {
    navigation<RootDestination.SplashGraph>(
        startDestination = SplashDestination.SplashScreen
    ) {
        composable<SplashDestination.SplashScreen> {
            val viewModel = hiltViewModel<SplashViewModel>()
            val splashRedirectScreenState by viewModel.splashRedirectScreenState.collectAsStateWithLifecycle()
            SplashScreen()
        }

    }
}